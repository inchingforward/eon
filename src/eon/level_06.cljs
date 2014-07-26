(ns eon.level-06
  "Maps.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(def level
  {:level 6
   :title "Maps"
   :question-fn make-question
   :curr-question 0})
