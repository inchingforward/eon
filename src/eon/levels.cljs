(ns eon.levels)

(def questions-per-level 5)

(defn make-basic-question []
  (let [q-a (rand-nth ["\"test\"" 1 "\\a" 2048 :key-word 15 "\"hello\"" "\\x" "\"eon\""])]
    {:question q-a
     :answer q-a
     :answered? false
     :points 100}))

(def level-1
  {:level 1
   :title "The Thing Itself"
   :question-fn make-basic-question
   :curr-question 0})

(defn make-bool-question []
  (let [result (rand-nth [true false])]
    {:question result
     :answer result
     :answered? false
     :points 100}))

(def level-2
  {:level 2
   :title "Truthiness"
   :question-fn make-bool-question
   :curr-question 0})

(defn make-arith-question []
  (let [operators {"+" + "-" - "*" * "/" /}
        op-key (rand-nth (keys operators))
        num1   (rand-int 10)
        num2   (rand-int 10)]
    {:question   (str "(" op-key " " num1 " " num2 ")")
     :answer     ((get operators op-key) num1 num2)
     :answered?  false
     :points     100}))

(def level-3
  {:level 3
   :title "Arithmetic"
   :question-fn make-arith-question
   :curr-question 0})

(def levels
  {1 level-1
   2 level-2
   3 level-3})

(defn make-level [level-num]
  (let [level (get levels level-num)]
    (merge level
           {:questions
             (take questions-per-level (repeatedly (:question-fn level)))})))
