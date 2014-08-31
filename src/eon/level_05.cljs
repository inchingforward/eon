(ns eon.level-05
  "Sequence Equality."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(= () '())" true)
         (make-question "(= [] [])" true)
         (make-question "(= () [])" true)
         (make-question "(= () [] {})" false)
         (make-question "(list? '())" true)
         (make-question "(list? [])" false)
         (make-question "(vector? [])" true)
         (make-question "(vector? '())" false)
         (make-question "(= [1 2 3] '(1 2 3))" true)
         (make-question "(= [1 2 3] #{1 2 3))" false)
         (make-question "(= [1 2 3] [(+ 1 0) (+ 2 0) (+ 3 0)])" true)
         (make-question "(= (cons 1 (cons 2 '())) '(1 2))" true)
         (make-question "(= (cons 1 (cons 2 '())) [1 2])" true)
         (make-question "(= [1 2] (conj (conj [] 2) 1))" false)
         (make-question "(= [2 1] (conj (conj [] 2) 1))" true)])

(defn make-level [num-questions]
  {:level 5
   :title "Sequence Equality"
   :questions (shuffle-and-take qs num-questions)})
