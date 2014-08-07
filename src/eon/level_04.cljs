(ns eon.level-04
  "Arithmetic.")

(defn make-add-question []
  (let [num1 (rand-int 10)
        num2 (rand-int 10)]
    {:question (str "(+ " num1 " " num2 ")")
     :answer   (+ num1 num2)}))

(defn make-sub-question []
  (let [num1 (rand-int 10)
        num2 (rand-nth (range (inc num1)))]
    {:question (str "(- " num1 " " num2 ")")
     :answer   (- num1 num2)}))

(defn make-mul-question []
  (let [num1 (rand-int 10)
        num2 (rand-int 10)]
    {:question (str "(* " num1 " " num2 ")")
     :answer   (* num1 num2)}))

(defn make-div-question []
  (let [num1 (rand-int [1 2 3 4 5 6 7 8 9])
        num2 (rand-nth [1 2 3 4 5 6 7 8 9])
        prod (* num1 num2)]
    {:question (str "(/ " prod " " num1 ")")
     :answer   num2}))

(def arith-fns [make-add-question, make-sub-question, make-mul-question, make-div-question])

(defn make-question []
  (let [question-fn (rand-nth arith-fns)]
    (merge (question-fn) {:answered? false :points 0})))

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 4
   :title "Arithmetic"
   :questions (make-questions num-questions)})

