(ns eon.level-05
  "Sequences.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(def level
  {:level 5
   :title "Sequences"
   :question-fn make-question
   :curr-question 0})
