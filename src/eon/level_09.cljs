(ns eon.level-09
  "Multimethods.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 9
   :title "Multimethods"
   :questions (make-questions num-questions)})
