(ns eon.level-07
  "Maps."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(:a {:a 1 :b 2})" 1)
         (make-question "(get {:a 1 :b 2} :a)" 1)
         (make-question "({:a 1 :b 2} :a)" 1)
         (make-question "(:b {:a 1 :b 2})" 2)
         (make-question "(get {:a 1 :b 2} :b)" 2)
         (make-question "({:a 1 :b 2} :b)" 2)
         (make-question "(:c {:a 1 :b 2})" "nil")
         (make-question "(:c {:a 1 :b 2} 3)" 3)
         (make-question "(:a (hash-map :a 1 :b 2))" 1)
         (make-question "(:b (hash-map :a 1 :b 2))" 2)
         (make-question "(:c (hash-map :a 1 :b 2))" "nil")
         (make-question "(contains? {:a 1 :b 2} :a)" true)
         (make-question "(contains? {:a 1 :b 2} :c)" false)
         (make-question "(map? {})" true)
         (make-question "(map? #{})" false)
         (make-question "(map? nil)" false)
         (make-question "(count {})" 0)
         (make-question "(count {:a 1})" 1)
         (make-question "(count {:a 1 :b 2})" 2)
         (make-question "(associative? {:a 1 :b 2})" true)
         (make-question "(get-in {:x {:a 1} :y {:a \"a\"}} [:x :a])" 1)
         (make-question "(get-in {:x {:a 1} :y {:a \"a\"}} [:y :a])" "\"a\"")
         (make-question "(get-in {:x {:a 1} :y {:a \"a\"}} [:x :y])" "nil")])

(defn make-level [num-questions]
  {:level 7
   :title "Maps"
   :questions (shuffle-and-take qs num-questions)})
