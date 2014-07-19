(ns eon.level-01
  "Basic evaluations:  things that evaluate to themselves.")

(defn make-question []
  (let [q-a (rand-nth ["\"test\"" 1 "\\a" 2048 :key-word 15 "\"hello\"" "\\x" "\"eon\""])]
    {:question q-a
     :answer q-a
     :answered? false
     :points 100}))

(def level
  {:level 1
   :title "The Thing Itself"
   :question-fn make-question
   :curr-question 0})
