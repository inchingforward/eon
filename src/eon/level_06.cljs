(ns eon.level-06
  "Sequences."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(first '(1 2 3))" 1)
         (make-question "(first (rest '(1 2 3)))" 2)
         (make-question "(nth '(1 2 3) 0)" 1)
         (make-question "(nth '(1 2 3) 1)" 2)
         (make-question "(nth '(1 2 3) 2)" 3)
         (make-question "(nth [1 2 3] 0)" 1)
         (make-question "(nth [1 2 3] 1)" 2)
         (make-question "(nth [1 2 3] 2)" 3)
         (make-question "(empty? '())" true)
         (make-question "(empty? '(1 2 3))" false)
         (make-question "(empty? [])" true)
         (make-question "(empty? [1 2 3])" false)])

(defn make-level [num-questions]
  {:level 6
   :title "Sequences"
   :questions (shuffle-and-take qs num-questions)})
