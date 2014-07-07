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

(defn change-question []
  (swap! game-state assoc :curr-question (inc (:curr-question @game-state))))

(defn get-question []
  (:question (nth (:questions @game-state)
                  (:curr-question @game-state))))

(defn get-answer []
  (:answer (nth (:questions @game-state)
                (:curr-question @game-state))))

(defn log []
  (.log js/console (str @game-state)))

(om/root
  (fn [app owner]
    (om/component
      (dom/div nil
        (dom/h1 nil (str "Level " (:level @game-state) ": " (:notes @game-state)))
        (dom/h1 nil (str (get-question) " = "
                         (get-answer)))
        (dom/input nil)
        (dom/button nil "Answer")
        (dom/button
           #js {:onClick change-question}
           "Change question")
        (dom/button
           #js {:onClick change-level}
           "Change level")
        (dom/button
           #js {:onClick #(swap! game-state merge (levels/make-level 1))}
           "Reset")
        (dom/button
           #js {:onClick log}
           "Log"))))
  game-state
  {:target (. js/document (getElementById "app"))})

