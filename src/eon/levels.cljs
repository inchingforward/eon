(ns eon.levels)

(defn make-arith-question []
  (let [operators {"+" + "-" - "*" * "/" /}
        op-key (rand-nth (keys operators))
        num1   (rand-int 10)
        num2   (rand-int 10)]
    {:question   (str "(" op-key " " num1 " " num2 ")")
     :answer     ((get operators op-key) num1 num2)
     :answered?  false
     :points     100}))

(def level-1
  {:level 1
   :title "Level 1"
   :notes "Baby's first evaluation"
   :fn make-arith-question})
