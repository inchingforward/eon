(ns eon.level-04
  "Equality.")

;; Examples
; (= 1 (+ 0 1) (- 5 4) (/ 9 9))
; (= "a" \a)
; (= "a" (str \a))
; (= :a "a")
; (= :a (keyword "a"))
; (= "hello" [\h \e \l \l \o])
; (= "hello" (str [\h \e \l \l \o]))
; (= "hello" (apply str [\h \e \l \l \o]))
; (= "hello" (str "hell" "o"))
; (identical? "hello" (str "hell" "o"))

(defn make-question []
  (let [nums [1 2 3]
        num1 (rand-nth nums)
        num2 (rand-nth nums)]
    {:question (str "(= " num1 " " num2 ")")
     :answer (== num1 num2)
     :answered? false
     :points 100}))

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 4
   :title "Equality"
   :questions (make-questions num-questions)})


