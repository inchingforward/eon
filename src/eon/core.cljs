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
  (swap! game-state assoc :level 2))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (dom/div nil
        (dom/h1 nil (str "Level " (:level @game-state) ": " (:notes @game-state)))
        (dom/h1 nil (str (:question (first (:questions @game-state))) " = "
                         (:answer   (first (:questions @game-state)))))
        (dom/button
           #js {:onClick change-level}
           "Change level")))))

(om/root widget nil
  {:target (. js/document (getElementById "app"))})

