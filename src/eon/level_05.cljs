(ns eon.level-05
  "Sequences.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 5
   :title "Sequences"
   :questions (make-questions num-questions)})
