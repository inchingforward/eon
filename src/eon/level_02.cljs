(ns eon.level-02
  "Boolean logic.")

(defn make-question []
  (let [result (rand-nth [true false])]
    {:question result
     :answer result
     :answered? false
     :points 100}))

(def level
  {:level 2
   :title "Truthiness"
   :question-fn make-question
   :curr-question 0})
