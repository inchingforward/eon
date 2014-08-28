(ns eon.level-07
  "Maps."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(:one {:one 1 :two 2})" 1)
         (make-question "(get {:one 1 :two 2} :one)" 1)
         (make-question "({:one 1 :two 2} :one)" 1)
         (make-question "(:two {:one 1 :two 2})" 2)
         (make-question "(get {:one 1 :two 2} :two)" 2)
         (make-question "({:one 1 :two 2} :two)" 2)
         (make-question "(:three {:one 1 :two 2})" "nil")
         (make-question "(:three {:one 1 :two 2} 3)" 3)
         (make-question "(contains? {:one 1 :two 2} :one)" true)
         (make-question "(contains? {:one 1 :two 2} :three)" false)
         (make-question "(map? {})" true)
         (make-question "(map? #{})" false)
         (make-question "(count {:one 1})" 1)
         (make-question "(count {:one 1 :two 2})" 2)
         (make-question "(associative? {:one 1 :two 2})" true)
         (make-question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:nums :two])" 2)
         (make-question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:letters :a])" "\"a\"")
         (make-question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:nums :three])" "nil")
         (make-question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:x :y])" "nil")])

(defn make-level [num-questions]
  {:level 7
   :title "Maps"
   :questions (shuffle-and-take qs num-questions)})
