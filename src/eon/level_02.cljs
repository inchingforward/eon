(ns eon.level-02
  "Boolean Logic.")

;; Examples
;; true
;; false
;; (not true)
;; (not false)
;; (and true true)
;; (and true false)
;; (if true false true)
;; (if (and true true) 1 2)
;; (if (not true) 1 2)
;; (if (not false) 1 2)

(defn make-question []
  (let [result (rand-nth [true false])]
    {:question result
     :answer result
     :answered? false
     :points 100}))

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 2
   :title "Truthiness"
   :questions (make-questions num-questions)})
