(ns eon.level-06
  "Maps.")

(defn make-question []
  {:question "test"
   :answer "test"
   :answered? false
   :points 100})

(defn make-questions [num-questions]
  (take num-questions (repeatedly make-question)))

(defn make-level [num-questions]
  {:level 6
   :title "Maps"
   :questions (make-questions num-questions)})
