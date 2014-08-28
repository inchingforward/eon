(ns eon.level-02
  "Boolean Logic."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "true" true)
         (make-question "false" false)
         (make-question "(not true)" false)
         (make-question "(not false)" true)
         (make-question "(not not)" false)
         (make-question "(and true true)" true)
         (make-question "(and true false)" false)
         (make-question "(and true (not false))" true)
         (make-question "(or true true)" true)
         (make-question "(or true false)" true)
         (make-question "(or false true)" true)
         (make-question "(or false false)" false)
         (make-question "(if true false true)" false)
         (make-question "(if true true false)" true)
         (make-question "(if (and true true) 1 2)" 1)
         (make-question "(if (not true) 1 2)" 2)
         (make-question "(or true false)" true)])

(defn make-level [num-questions]
  {:level 2
   :title "True/False"
   :questions (shuffle-and-take qs num-questions)})
