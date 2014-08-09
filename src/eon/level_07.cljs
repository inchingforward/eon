(ns eon.level-07
  "Maps.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 7
   :title "Maps"
   :questions (make-questions num-questions)})
