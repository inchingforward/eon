(ns eon.core
  (:require [figwheel.client :as fw]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [eon.levels :as levels]))

(enable-console-print!)

(fw/watch-and-reload
 :jsload-callback (fn []
                    ;; (stop-and-start-my app)
                    ))

(def initial-state (levels/make-level 1))

(def game-state (atom initial-state))

(defn change-level []
  (swap! game-state merge (levels/make-level 2)))

(defn advance-question []
  (swap! game-state assoc :curr-question (inc (:curr-question @game-state))))

(defn get-question []
  (:question (nth (:questions @game-state)
                  (:curr-question @game-state))))

(defn get-answer []
  (:answer (nth (:questions @game-state)
                (:curr-question @game-state))))

(defn answer-question [node answer-attempt answer]
  (set! (.-value node) "")
  (advance-question))

(defn fail-question [node answer-attempt answer]
  (.select node)
  (.log js/console (str "the correct answer is " answer )))

(defn attempt-answer-question [app owner]
  (let [node (om/get-node owner "answer")
        answer-attempt (.-value node)
        answer (str (get-answer))]
    (if (= answer answer-attempt)
      (answer-question node answer-attempt answer)
      (fail-question node answer-attempt answer))))

(om/root
  (fn [app owner]
    (om/component
      (dom/div nil
        (dom/div #js {:id "level-box"}
          (dom/h1 nil (str "Level " (:level @game-state) ": " (:notes @game-state))))
        (dom/div #js {:id "question-box"}
          (dom/h1 nil (str (get-question))))
        (dom/div #js {:id "answer-box"}
          (dom/input #js {:type "text" :ref "answer" :id "answer"
                          :spellCheck "false"
                          :autoComplete "off"
                          :onKeyPress #(when (== (.-keyCode %) 13)
                                (attempt-answer-question app owner))}))
        (dom/div #js {:id "debug-box"}
          (dom/button
            #js {:onClick change-level}
            "Change level")
          (dom/button
            #js {:onClick #(swap! game-state merge (levels/make-level 1))}
            "Reset")
          (dom/button
            #js {:onClick #(.log js/console (str @game-state))}
            "Log State")))))
  game-state
  {:target (. js/document (getElementById "app"))})

