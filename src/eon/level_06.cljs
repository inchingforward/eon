(ns eon.level-06
  "Sequences."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(first '(1 2 3))" 1)
         (make-question "(first (rest '(1 2 3)))" 2)
         (make-question "(first (rest (rest [1 2 3])))" 3)
         (make-question "(first (first [[1 2 3]]))" 1)
         (make-question "(first (rest (first [[1 2 3]])))" 2)
         (make-question "(nth '(1 2 3) 0)" 1)
         (make-question "(nth '(1 2 3) 1)" 2)
         (make-question "(nth '(1 2 3) 2)" 3)
         (make-question "(nth '(:a :b :c) 0)" :a)
         (make-question "(nth '(:a :b :c) 1)" :b)
         (make-question "(nth '(:a :b :c) 2)" :c)
         (make-question "(nth [1 2 3] 0)" 1)
         (make-question "(nth [1 2 3] 1)" 2)
         (make-question "(nth [1 2 3] 2)" 3)
         (make-question "(nth [:a :b :c] 0)" :a)
         (make-question "(nth [:a :b :c] 1)" :b)
         (make-question "(nth [:a :b :c] 2)" :c)
         (make-question "(empty? '())" true)
         (make-question "(empty? '(nil))" false)
         (make-question "(empty? '(1 2 3))" false)
         (make-question "(empty? [])" true)
         (make-question "(empty? [nil])" false)
         (make-question "(empty? [1 2 3])" false)])

(defn make-level [num-questions]
  {:level 6
   :title "Sequences"
   :questions (shuffle-and-take qs num-questions)})
