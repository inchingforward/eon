(ns eon.level-02
  "Boolean Logic.")

(def qs [{:question "true" :answer true}
         {:question "false" :answer false}
         {:question "(not true)" :answer false}
         {:question "(not false)" :answer true}
         {:question "(not not)" :answer false}
         {:question "(and true true)" :answer true}
         {:question "(and true false)" :answer false}
         {:question "(and true (not false))" :answer true}
         {:question "(or true true)" :answer true}
         {:question "(or true false)" :answer true}
         {:question "(or false true)" :answer true}
         {:question "(or false false)" :answer true}
         {:question "(if true false true)" :answer false}
         {:question "(if (and true true) 1 2)" :answer 1}
         {:question "(if (not true) 1 2)" :answer 2}
         {:question "(or true false)" :answer true}])

(defn make-questions [num-questions]
  (vec (take num-questions
             (shuffle (map #(merge % {:answered? false :points 100}) qs)))))

(defn make-level [num-questions]
  {:level 2
   :title "Truthiness"
   :questions (make-questions num-questions)})
