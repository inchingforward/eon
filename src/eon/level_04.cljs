(ns eon.level-04
  "Scalar Equality."
  (:require [eon.question :refer [make-question shuffle-and-take]]))

(def qs [(make-question "(= 1 1)" true)

         (make-question "(= 3.14 3.14)" true)
         (make-question "(= 3.14 3.1400)" true)
         (make-question "(= 1 1.0)" false)
         (make-question "(== 1 1.0)" true)
         (make-question "(= 1 1M)" false)
         (make-question "(== 1 1M)" true)
         (make-question "(= 1 (+ 0 1) (- 5 4) (/ 9 9))" true)
         (make-question "(= \"a\" \\a)" false)
         (make-question "(= \"a\" (str \\a))" true)
         (make-question "(= \\a (char 97)" true)
         (make-question "(= :a \"a\")" false)
         (make-question "(= :a (keyword \"a\"))" true)
         (make-question "(= \\a (first \"abc\"))" true)
         (make-question "(= 'a \"a\")" false)
         (make-question "(= 'a (symbol \"a\"))" true)
         (make-question "(= 'a (symbol (str \\a)))" true)
         (make-question "(= \"hello\" [\\h \\e \\l \\l \\o])" false)
         (make-question "(= \"hello\" (str [\\h \\e \\l \\l \\o]))" false)
         (make-question "(= \"hello\" (apply str [\\h \\e \\l \\l \\o]))" true)
         (make-question "(= \"hello\" (str \"hell\" \"o\"))" true)])

(defn make-level [num-questions]
  {:level 4
   :title "Scalar Equality"
   :questions (shuffle-and-take qs num-questions)})


