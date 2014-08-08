(ns eon.level-07
  "Higher Order Functions.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 7
   :title "Higher Order Functions"
   :questions (make-questions num-questions)})
