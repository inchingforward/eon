(ns eon.level-07
  "Maps."
  (:require [eon.question :as q]))

(def qs [(q/make-question "(:one {:one 1 :two 2))" 1)
         (q/make-question "(get {:one 1 :two 2) :one)" 1)
         (q/make-question "({:one 1 :two 2) :one)" 1)
         (q/make-question "(:two {:one 1 :two 2))" 2)
         (q/make-question "(get {:one 1 :two 2) :two)" 2)
         (q/make-question "({:one 1 :two 2) :two)" 2)
         (q/make-question "(:three {:one 1 :two 2))" "nil")
         (q/make-question "(:three {:one 1 :two 2) 3)" 3)
         (q/make-question "(contains? {:one 1 :two 2) :one)" true)
         (q/make-question "(contains? {:one 1 :two 2) :three)" false)
         (q/make-question "(map? {))" true)
         (q/make-question "(map? #{))" false)
         (q/make-question "(count {:one 1))" 1)
         (q/make-question "(count {:one 1 :two 2))" 2)
         (q/make-question "(associative? {:one 1 :two 2))" true)
         (q/make-question "(get-in {:nums {:one 1 :two 2) :letters {:a \"a\" :b \"b\")) [:nums :two])" 2)
         (q/make-question "(get-in {:nums {:one 1 :two 2) :letters {:a \"a\" :b \"b\")) [:letters :a])" "\"a\"")
         (q/make-question "(get-in {:nums {:one 1 :two 2) :letters {:a \"a\" :b \"b\")) [:nums :three])" "nil")
         (q/make-question "(get-in {:nums {:one 1 :two 2) :letters {:a \"a\" :b \"b\")) [:x :y])" "nil")])

(defn make-level [num-questions]
  {:level 7
   :title "Maps"
   :questions (q/shuffle-and-take qs num-questions)})
