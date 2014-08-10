(ns eon.level-04
  "Scalar Equality.")

(def qs [{:question "(= 1 (+ 0 1) (- 5 4) (/ 9 9))" :answer true}
         {:question "(= \"a\" \\a)" :answer false}
         {:question "(= \"a\" (str \\a))" :answer true}
         {:question "(= :a \"a\")" :answer false}
         {:question "(= :a (keyword \"a\"))" :answer true}
         {:question "(= \"hello\" [\\h \\e \\l \\l \\o])" :answer false}
         {:question "(= \"hello\" (str [\\h \\e \\l \\l \\o]))" :answer false}
         {:question "(= \"hello\" (apply str [\\h \\e \\l \\l \\o]))" :answer true}
         {:question "(= \"hello\" (str \"hell\" \"o\"))" :answer true}
         {:question "(identical? \"hello\" (str \"hell\" \"o\"))" :answer false}])

(defn make-questions [num-questions]
  (vec (take num-questions (map #(merge % {:answered? false :points 100}) qs))))

(defn make-level [num-questions]
  {:level 4
   :title "Scalar Equality"
   :questions (make-questions num-questions)})


