(ns eon.level-03
  "Nil."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(nil? nil)" true)
         (make-question "(nil? \"\")" false)
         (make-question "(nil? true)" false)
         (make-question "(nil? false)" false)
         (make-question "nil" "nil")
         (make-question "(nil? '(nil))" false)
         (make-question "(nil? '())" false)
         (make-question "(or nil nil)" "nil")
         (make-question "(or nil true)" true)
         (make-question "(seq '())" "nil")
         (make-question "(seq [])" "nil")
         (make-question "(nil? (seq '()))" true)
         (make-question "(nil? (seq []))" true)
         (make-question "(nil? (first '(nil)))" true)
         (make-question "(nil? (first []))" true)
         (make-question "(if '() true false)" true)
         (make-question "(if [] true false)" true)
         (make-question "(if {} true false)" true)])

(defn make-level [num-questions]
  {:level 3
   :title "Nil"
   :questions (shuffle-and-take qs num-questions)})
