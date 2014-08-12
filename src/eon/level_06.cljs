(ns eon.level-06
  "Sequences.")

(def qs [{:question "(first '(1 2 3))" :answer 1}
         {:question "(first (rest '(1 2 3)))" :answer 2}
         {:question "(nth '(1 2 3) 0)" :answer 1}
         {:question "(nth '(1 2 3) 1)" :answer 2}
         {:question "(nth '(1 2 3) 2)" :answer 3}
         {:question "(nth [1 2 3] 0)" :answer 1}
         {:question "(nth [1 2 3] 1)" :answer 2}
         {:question "(nth [1 2 3] 2)" :answer 3}
         {:question "(empty? '())" :answer true}
         {:question "(empty? '(1 2 3))" :answer false}
         {:question "(empty? [])" :answer true}
         {:question "(empty? [1 2 3])" :answer false}])

(defn make-questions [num-questions]
  (vec (take num-questions
             (shuffle (map #(merge % {:answered? false :points 100}) qs)))))

(defn make-level [num-questions]
  {:level 6
   :title "Sequences"
   :questions (make-questions num-questions)})
