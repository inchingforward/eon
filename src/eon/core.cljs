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

(defn eon-view [app owner]
  (reify
    om/IRender
      (render [this]
        (dom/div #js {:ref "app-world" :id "app-world"}
          (dom/div #js {:id "level-box"}
            (dom/h1 nil (str (:level @game-state) ": " (:title @game-state))))
          (dom/div #js {:id "question-box"}
            (dom/h2 #js {:ref "question-display" :id "question-display" }
                    (str (get-question))))
          (dom/div #js {:id "answer-box"}
            (dom/input #js {:ref "answer-input"
                            :id "answer-input"
                            :onKeyPress #(key-entered (.-keyCode %) app owner)} ""))
          (dom/div #js {:id "tool-box"}
            (dom/button
              #js {:onClick advance-level}
              "Change level")
            (dom/button
              #js {:onClick #(swap! game-state merge (levels/make-level 1))}
              "Reset")
            (dom/button
              #js {:onClick #(set! (.-innerHTML (om/get-node owner "debug"))
                                   (str @game-state))}
              "Show State"))
          (dom/div #js {:id "debug-box"}
            (dom/h4 #js {:id "debug" :ref "debug"} ""))))
     om/IDidMount
      (did-mount [this]
        (.focus (om/get-node owner "answer-input")))))

(om/root eon-view game-state
  {:target (. js/document (getElementById "app"))})

