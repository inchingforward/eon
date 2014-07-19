(ns eon.level-03
  "Equality.")

(defn make-question []
  (let [nums [1 2 3]
        num1 (rand-nth nums)
        num2 (rand-nth nums)]
    {:question (str "(== " num1 " " num2 ")")
     :answer (== num1 num2)
     :answered? false
     :points 100}))

(def level
  {:level 3
   :title "Equality"
   :question-fn make-question
   :curr-question 0})
