(ns eon.level-02
  "Boolean Logic.")

;; Examples
;; (< 5 3)
;; (= 5 5)
;; (if [] true false)
;; (and (> 1 5) (= 2 4))
;; (not (= 2 2))
;; (not (= 2 3))

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
