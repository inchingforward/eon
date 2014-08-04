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

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 3
   :title "Equality"
   :questions (make-questions num-questions)})
