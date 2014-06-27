(ns eon.core
  (:require [figwheel.client :as fw]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(fw/watch-and-reload
 :jsload-callback (fn []
                    ;; (stop-and-start-my app)
                    ))

(def initial-state {:level 1
                    :forms []})

(defonce game-state (atom initial-state))

(defn change-level []
  (js/alert "Testing"))

(defn make-form-question []
  {:question "(+ 1 2)"
   :answer 3
   :answered? false
   :points 100})

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (dom/div nil
        (dom/h1 nil (str "Level " (:level @game-state)))
        (dom/button
           #js {:onClick change-level}
           "Change level")))))

(om/root widget {:text "Eon!"}
  {:target (. js/document (getElementById "app"))})

