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

(def initial-state {:level 1
                    :forms []})

(defonce game-state (atom initial-state))

(defn change-level []
  (js/alert "Testing"))

(defn make-arith-question []
  (let [operators {"+" + "-" - "*" * "/" /}
        op-key (rand-nth (keys operators))
        num1   (rand-int 10)
        num2   (rand-int 10)]
    {:question   (str "(" op-key " " num1 " " num2 ")")
     :answer     ((get operators op-key) num1 num2)
     :answered?  false
     :points     100}))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (dom/div nil
        (dom/h1 nil (str "Level " (:level @game-state)))
        (dom/h1 nil (str (:question data) " = " (:answer data)))
        (dom/button
           #js {:onClick change-level}
           "Change level")))))

(om/root widget ((:fn levels/level-1))
  {:target (. js/document (getElementById "app"))})

