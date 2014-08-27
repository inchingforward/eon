(ns eon.level-04
  "Scalar Equality."
  (:require [eon.question :as q]))

(def qs [(q/make-question "(= 1 1)" true)
         (q/make-question "(= 3.14 3.14)" true)
         (q/make-question "(= 3.14 3.1400)" true)
         (q/make-question "(= 1 (+ 0 1) (- 5 4) (/ 9 9))" true)
         (q/make-question "(= \"a\" \\a)" false)
         (q/make-question "(= \"a\" (str \\a))" true)
         (q/make-question "(= :a \"a\")" false)
         (q/make-question "(= :a (keyword \"a\"))" true)
         (q/make-question "(= \"hello\" [\\h \\e \\l \\l \\o])" false)
         (q/make-question "(= \"hello\" (str [\\h \\e \\l \\l \\o]))" false)
         (q/make-question "(= \"hello\" (apply str [\\h \\e \\l \\l \\o]))" true)
         (q/make-question "(= \"hello\" (str \"hell\" \"o\"))" true)
         (q/make-question "(identical? \"hello\" (str \"hell\" \"o\"))" false)
         (q/make-question "(identical? \"hello\" \"hello\")" true)])

(defn make-level [num-questions]
  {:level 4
   :title "Scalar Equality"
   :questions (q/shuffle-and-take qs num-questions)})


