(ns eon.level-04
  "Arithmetic.")

(defn make-question []
  (let [operators {"+" + "-" - "*" * "/" /}
        op-key (rand-nth (keys operators))
        num1   (rand-int 10)
        num2   (rand-int 10)]
    {:question   (str "(" op-key " " num1 " " num2 ")")
     :answer     ((get operators op-key) num1 num2)
     :answered?  false
     :points     100}))

(def level
  {:level 4
   :title "Arithmetic"
   :question-fn make-question
   :curr-question 0})
