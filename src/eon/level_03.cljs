(ns eon.level-03
  "Nil."
  (:require [eon.question :as q]))

(def qs [(q/make-question "(nil? nil)" true)
         (q/make-question "(nil? true)" false)
         (q/make-question "(nil? false)" false)
         (q/make-question "nil" "nil")
         (q/make-question "(not nil)" true)
         (q/make-question "(nil? '(nil))" false)
         (q/make-question "(nil? '())" false)
         (q/make-question "(or nil nil)" "nil")
         (q/make-question "(or nil true)" true)
         (q/make-question "(seq? '())" true)
         (q/make-question "(seq '())" "nil")
         (q/make-question "(seq [])" "nil")
         (q/make-question "(nil? (seq '()))" true)
         (q/make-question "(nil? (seq []))" true)
         (q/make-question "(nil? (first '(nil)))" true)
         (q/make-question "(if '() true false)" true)])

(defn make-level [num-questions]
  {:level 3
   :title "Nil"
   :questions (q/shuffle-and-take qs num-questions)})
