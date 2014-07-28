(ns eon.core
  (:require [figwheel.client :as fw]
            [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as dom :include-macros true]
            [eon.levels :as levels]))

(enable-console-print!)

(def initial-state (merge (levels/make-level 1) {:player-answer ""}))

(def game-state (atom initial-state))

(defn advance-level []
  (swap! game-state merge (levels/make-level (inc (:level @game-state)))))

(defn advance-question []
  (swap! game-state assoc :curr-question (inc (:curr-question @game-state))))

(defn get-question []
  (:question (nth (:questions @game-state)
                  (:curr-question @game-state))))

(defn get-answer []
  (:answer (nth (:questions @game-state)
                (:curr-question @game-state))))

(defn has-more-questions []
  (< (:curr-question @game-state)
     (dec levels/questions-per-level)))

(defn answer-question [owner]
  (if (has-more-questions)
    (advance-question)
    (advance-level)))

(defn attempt-answer-question [app owner]
  (let [actual-answer (str (get-answer))
        player-answer (.-value (om/get-node owner "answer-input"))]
    (set! (.-value (om/get-node owner "answer-input")) "")
    (when (== actual-answer player-answer)
      (answer-question owner))))

(defn key-entered [keyCode app owner]
  (when (= keyCode 13)
    (attempt-answer-question app owner)))

(defcomponent eon-view [app owner]
  (render [this]
    (dom/div {:ref "app-world" :id "app-world"}
      (dom/div {:id "level-box"}
        (dom/h1 (str (:level @game-state) ": " (:title @game-state))))
      (dom/div {:id "question-box"}
        (dom/h2 {:ref "question-display" :id "question-display"}
                (str (get-question))))
      (dom/div {:id "answer-box"}
        (dom/input {:ref "answer-input"
                    :id "answer-input"
                    :onKeyPress #(key-entered (.-keyCode %) app owner)} ""))))
  (did-mount [this]
    (.focus (om/get-node owner "answer-input"))))

(om/root eon-view game-state
  {:target (. js/document (getElementById "app"))})
