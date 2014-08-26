(ns eon.level-02
  "Boolean Logic."
  (:require [eon.question :as q]))

(def qs [(q/make-question "true" true)
         (q/make-question "false" false)
         (q/make-question "(not true)" false)
         (q/make-question "(not false)" true)
         (q/make-question "(not not)" false)
         (q/make-question "(and true true)" true)
         (q/make-question "(and true false)" false)
         (q/make-question "(and true (not false))" true)
         (q/make-question "(or true true)" true)
         (q/make-question "(or true false)" true)
         (q/make-question "(or false true)" true)
         (q/make-question "(or false false)" false)
         (q/make-question "(if true false true)" false)
         (q/make-question "(if (and true true) 1 2)" 1)
         (q/make-question "(if (not true) 1 2)" 2)
         (q/make-question "(or true false)" true)])

(defn make-level [num-questions]
  {:level 2
   :title "Truthiness"
   :questions (q/shuffle-and-take qs num-questions)})
