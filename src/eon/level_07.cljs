(ns eon.level-07
  "Higher Order Functions.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(def level
  {:level 6
   :title "Higher Order Functions"
   :question-fn make-question
   :curr-question 0})
