(ns eon.level-05
  "Sequence Equality.")

(def qs [{:question "(= () '())" :answer true}
         {:question "(= [] [])" :answer true}
         {:question "(= () [])" :answer true}
         {:question "(= [1 2 3] '(1 2 3))" :answer true}
         {:question "(= [1 2 3] #{1 2 3})" :answer false}
         {:question "(= () [] {})" :answer false}
         {:question "(= [1 2 3] [(+ 1 0) (+ 2 0) (+ 3 0)])" :answer true}
         {:question "(= (cons 1 (cons 2 (cons 3 '()))) (1 2 3))" :answer true}
         {:question "(= (cons 1 (cons 2 (cons 3 '()))) [1 2 3])" :answer true}
         {:question "(= (conj (conj (conj [] 1) 2) 3))" :answer true}
         {:question "(= [1 2 3] (conj (conj (conj [] 3) 2) 1))" :answer false}
         {:question "(= [3 2 1] (conj (conj (conj [] 3) 2) 1))" :answer true}])

(defn make-questions [num-questions]
  (vec (take num-questions
             (shuffle (map #(merge % {:answered? false :points 100}) qs)))))

(defn make-level [num-questions]
  {:level 5
   :title "Sequence Equality"
   :questions (make-questions num-questions)})
