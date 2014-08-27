(ns eon.level-06
  "Sequences."
  (:require [eon.question :as q]))

(def qs [(q/make-question "(first '(1 2 3))" 1)
         (q/make-question "(first (rest '(1 2 3)))" 2)
         (q/make-question "(nth '(1 2 3) 0)" 1)
         (q/make-question "(nth '(1 2 3) 1)" 2)
         (q/make-question "(nth '(1 2 3) 2)" 3)
         (q/make-question "(nth [1 2 3] 0)" 1)
         (q/make-question "(nth [1 2 3] 1)" 2)
         (q/make-question "(nth [1 2 3] 2)" 3)
         (q/make-question "(empty? '())" true)
         (q/make-question "(empty? '(1 2 3))" false)
         (q/make-question "(empty? [])" true)
         (q/make-question "(empty? [1 2 3])" false)])

(defn make-level [num-questions]
  {:level 6
   :title "Sequences"
   :questions (q/shuffle-and-take qs num-questions)})
