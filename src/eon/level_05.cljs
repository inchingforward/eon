(ns eon.level-05
  "Sequence Equality."
  (:require [eon.question :as q]))

(def qs [(q/make-question "(= () '())" true)
         (q/make-question "(= [] [])" true)
         (q/make-question "(= () [])" true)
         (q/make-question "(= [1 2 3] '(1 2 3))" true)
         (q/make-question "(= [1 2 3] #{1 2 3))" false)
         (q/make-question "(= () [] {))" false)
         (q/make-question "(= [1 2 3] [(+ 1 0) (+ 2 0) (+ 3 0)])" true)
         (q/make-question "(= (cons 1 (cons 2 (cons 3 '()))) (1 2 3))" true)
         (q/make-question "(= (cons 1 (cons 2 (cons 3 '()))) [1 2 3])" true)
         (q/make-question "(= [1 2 3] (conj (conj (conj [] 3) 2) 1))" false)
         (q/make-question "(= [3 2 1] (conj (conj (conj [] 3) 2) 1))" true)])

(defn make-level [num-questions]
  {:level 5
   :title "Sequence Equality"
   :questions (q/shuffle-and-take qs num-questions)})
