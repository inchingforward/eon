(ns eon.core
  (:require [reagent.core :as reagent :refer [atom]]
            [eon.levels :as levels]))

(enable-console-print!)

(def questions-per-level 10)

(def failed-answer-point-penalty 10)

(def initial-state
  (merge {:levels (levels/make-levels questions-per-level)}
         {:curr-level 0 :curr-question 0}))

(def game-state (atom initial-state))

(defn end-game []
  (let [app (.getElementById js/document "app")
        game-over (.getElementById js/document "game-over")]
    (set! (-> game-over .-style .-display) "block")
    (set! (-> app .-style .-display) "none")))

(defn advance-level []
    (swap! game-state assoc :curr-level (inc (:curr-level @game-state)))
    (swap! game-state assoc :curr-question 0))

(defn advance-question []
  (swap! game-state assoc :curr-question (inc (:curr-question @game-state))))

(defn get-current-level []
  (nth (:levels @game-state)
       (:curr-level @game-state)))

(defn get-question []
  "Gets the current question in the current level."
  (let [level (get-current-level)]
    (nth (:questions level)
         (:curr-question @game-state))))

(defn get-answer []
  "Gets the actual answer to the current question."
  (:answer (get-question)))

(defn has-more-levels []
  (< (inc (:curr-level @game-state))
    (count (:levels @game-state))))

(defn has-more-questions []
  (< (:curr-question @game-state)
     (dec questions-per-level)))

(defn answer-question []
  "Marks the question answered, then moves on to the next question,
  level, or game over."
  (swap! game-state
         assoc-in
         [:levels (:curr-level @game-state) :questions (:curr-question @game-state) :answered?]
         true)
  (if (has-more-questions)
    (advance-question)
    (if (has-more-levels)
      (advance-level)
      (end-game))))

(defn deduct-points []
  (let [curr-points (:points (get-question))
        curr-level (:curr-level @game-state)
        curr-question (:curr-question @game-state)]
    (swap! game-state
           assoc-in
           [:levels curr-level :questions curr-question :points]
           (- curr-points failed-answer-point-penalty))))

(defn attempt-answer-question []
  "Tries to answer the question based on the player's answer.  If the
  answer is correct, advances the question (including the level if on
  the last question).  If the answer is incorrect, deducts points from
  the current question."
  (let [actual-answer (str (get-answer))
        answer-input (.getElementById js/document "answer-input")
        player-answer (.-value answer-input)]
    (set! (.-value answer-input) "")
    (if (== actual-answer player-answer)
      (answer-question)
      (deduct-points))))

(defn key-entered [keyCode]
  (when (= keyCode 13)
    (attempt-answer-question)))

(defn start-game []
  "Hides the attract component and displays the game component."
  (let [attract (.getElementById js/document "attract")
        app     (.getElementById js/document "app")
        input   (.getElementById js/document "answer-input")]
    (set! (-> attract .-style .-display) "none")
    (set! (-> app .-style .-display) "block")
    (.focus input)))

(defn calculate-points []
  (->> (:levels @game-state)
       (map :questions)
       flatten
       (filter :answered?)
       (map :points)
       (reduce +)))

(defn game-component []
  (let [level (get-current-level)
        question (:question (get-question))]
    [:div#app-world
     [:div#level-box
      [:h1 (str (:level level) ": " (:title level))]]
     [:div#question-box
      [:h2#question-display (str question)]]
     [:div#answer-box
      [:input#answer-input {:on-key-press #(key-entered (.-keyCode %))}]]]))

(defn attract-component []
  [:div
   [:h1 "EON!"]
   [:button#start-button {:on-click #(start-game)} "Start"]
   [:p [:a {:href "about.html"} "About"]]])

(defn game-over-component []
  (let [points (calculate-points)
        total-possible (* (* 100 questions-per-level)
                          (count (:levels @game-state)))
        missed (/ (- total-possible points) 10)]
    [:div
     [:h1 "Game over!"]
     [:p#points (str "Points: " points " / " total-possible)]
     [:p#missed (if (zero? missed) "Perfect!" (str "Incorrect Tries: " missed))]
     [:p [:a {:href "about.html"} "About"]]]))

(reagent/render-component [game-component] (.getElementById js/document "app"))
(reagent/render-component [attract-component] (.getElementById js/document "attract"))
(reagent/render-component [game-over-component] (.getElementById js/document "game-over"))
