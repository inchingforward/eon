(ns eon.level-01
  "Basic evaluations:  things that evaluate to themselves.")

(defn make-question []
  (let [q-a (rand-nth ["\"test\"" 1 "\\a" 2048 :key-word 15 "\"hello\"" "\\x" "\"eon\""])]
    {:question q-a
     :answer q-a
     :answered? false
     :points 100}))

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 1
   :title "The Thing Itself"
   :questions (make-questions num-questions)})
