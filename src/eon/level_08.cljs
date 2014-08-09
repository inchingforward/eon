(ns eon.level-08
  "Higher Order Functions")

; map, filter, anonymous functions

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 8
   :title "Higher Order Functions"
   :questions (make-questions num-questions)})
