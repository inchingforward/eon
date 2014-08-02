(ns eon.core
  (:require [reagent.core :as reagent :refer [atom]]
            [eon.levels :as levels]))

(enable-console-print!)

(def questions-per-level 5)

(def game-state
  (atom
    (merge {:levels (levels/make-levels questions-per-level)}
           {:curr-level 0
            :curr-question 0})))

(defn advance-level []
  (swap! game-state assoc :curr-level (inc (:curr-level @game-state))))

(defn advance-question []
  (swap! game-state assoc :curr-question (inc (:curr-question @game-state))))

(defn get-level []
  (nth (:levels @game-state)
       (:curr-level @game-state)))

(defn get-question []
  (let [level (get-level)]
    (nth (:questions level)
         (:curr-question @game-state))))

(defn get-answer [] (:answer (get-question)))

(defn has-more-questions []
  (< (:curr-question @game-state)
     (dec questions-per-level)))

(defn answer-question []
  (if (has-more-questions)
    (advance-question)
    (advance-level)))

(defn attempt-answer-question []
  (let [actual-answer (str (get-answer))
        answer-input (.getElementById js/document "answer-input")
        player-answer (.-value answer-input)]
    (set! (.-value answer-input) "")
    (when (== actual-answer player-answer)
      (answer-question))))

(defn key-entered [keyCode]
  (when (= keyCode 13)
    (attempt-answer-question)))

(defn start-game []
  (let [attract (.getElementById js/document "attract")
        app     (.getElementById js/document "app")
        input   (.getElementById js/document "answer-input")]
    (set! (-> attract .-style .-display) "none")
    (set! (-> app .-style .-display) "block")
    (.focus input)))

(defn game-component []
  (let [level (get-level)
        question (:question (get-question))]
    [:div#app-world
     [:div#level-box
      [:h1 (str (:level level) ": " (:title level))]]
     [:div#question-box
      [:h2#question-display (str question)]]
     [:div#answer-box
      [:input#answer-input {:on-key-press #(key-entered (.-keyCode %))}]]]))

(defn attract-component []
  [:div#attract
   [:h1 "EON!"]
   [:button#start-button {:on-click #(start-game)} "Start"]])

(defn game-over-component []
  [:div#game-over
   [:h1 "Game over!"]])

(reagent/render-component [game-component] (.getElementById js/document "app"))
(reagent/render-component [attract-component] (.getElementById js/document "attract"))
(reagent/render-component [game-over-component] (.getElementById js/document "game-over"))

