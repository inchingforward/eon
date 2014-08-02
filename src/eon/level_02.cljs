(ns eon.level-02
  "Boolean logic.")

(defn make-question []
  (let [result (rand-nth [true false])]
    {:question result
     :answer result
     :answered? false
     :points 100}))

(defn make-questions [num-questions]
  (take num-questions (repeatedly make-question)))

(defn make-level [num-questions]
  {:level 2
   :title "Truthiness"
   :questions (make-questions num-questions)})
