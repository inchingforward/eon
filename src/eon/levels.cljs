(ns eon.levels)

(defn make-basic-question []
  (let [q-a (rand-nth ["'test'" 1 \A 2048 :key-word "'hello'"])]
    {:question q-a
     :answer q-a
     :answered? false
     :points 100}))

(def level-1
  {:level 1
   :title "Level 1"
   :notes "Basics"
   :question-fn make-basic-question
   :curr-question 1})

(defn make-arith-question []
  (let [operators {"+" + "-" - "*" * "/" /}
        op-key (rand-nth (keys operators))
        num1   (rand-int 10)
        num2   (rand-int 10)]
    {:question   (str "(" op-key " " num1 " " num2 ")")
     :answer     ((get operators op-key) num1 num2)
     :answered?  false
     :points     100}))

(def level-2
  {:level 2
   :title "Level 2"
   :notes "Arithmetic"
   :question-fn make-arith-question
   :curr-question 1})

(def levels
  {1 level-1
   2 level-2})

(defn make-level [level-num]
  (let [level (get levels level-num)]
    (merge level {:questions (repeatedly 10 (:question-fn level))})))
