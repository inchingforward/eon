(ns eon.level-03
  "Nil.")

(def qs [{:question "(nil? nil)" :answer true}
         {:question "(nil? true)" :answer false}
         {:question "(nil? false)" :answer false}
         {:question "nil" :answer "nil"}
         {:question "(not nil)" :answer true}
         {:question "(nil? '(nil))" :answer false}
         {:question "(nil? '())" :answer false}
         {:question "(or nil nil)" :answer nil}
         {:question "(or nil true)" :answer true}
         {:question "(seq? '())" :answer true}
         {:question "(seq '())" :answer nil}
         {:question "(seq [])" :answer nil}
         {:question "(nil? (seq '()))" :answer true}
         {:question "(nil? (seq []))" :answer true}
         {:question "(nil? (first '(nil)))" :answer true}
         {:question "(if '() true false)" :answer true}])

(defn make-questions [num-questions]
  (vec (take num-questions
             (shuffle (map #(merge % {:answered? false :points 100}) qs)))))

(defn make-level [num-questions]
  {:level 3
   :title "Nil"
   :questions (make-questions num-questions)})
