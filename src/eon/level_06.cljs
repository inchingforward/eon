(ns eon.level-06
  "Sequences.")

; first, rest, nth (first (rest n)), into, get, cons

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 6
   :title "Sequences"
   :questions (make-questions num-questions)})
