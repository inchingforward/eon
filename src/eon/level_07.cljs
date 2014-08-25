(ns eon.level-07
  "Maps.")

(def qs [{:question "(:one {:one 1 :two 2})" :answer 1}
         {:question "(get {:one 1 :two 2} :one)" :answer 1}
         {:question "({:one 1 :two 2} :one)" :answer 1}
         {:question "(:two {:one 1 :two 2})" :answer 2}
         {:question "(get {:one 1 :two 2} :two)" :answer 2}
         {:question "({:one 1 :two 2} :two)" :answer 2}
         {:question "(:three {:one 1 :two 2})" :answer "nil"}
         {:question "(:three {:one 1 :two 2} 3)" :answer 3}
         {:question "(contains? {:one 1 :two 2} :one)" :answer true}
         {:question "(contains? {:one 1 :two 2} :three)" :answer false}
         {:question "(map? {})" :answer true}
         {:question "(map? #{})" :answer false}
         {:question "(count {:one 1})" :answer 1}
         {:question "(count {:one 1 :two 2})" :answer 2}
         {:question "(associative? {:one 1 :two 2})" :answer true}
         {:question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:nums :two])" :answer 2}
         {:question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:letters :a])" :answer "\"a\""}
         {:question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:nums :three])" :answer "nil"}
         {:question "(get-in {:nums {:one 1 :two 2} :letters {:a \"a\" :b \"b\"}} [:x :y])" :answer "nil"}])

(defn make-questions [num-questions]
  (vec (take num-questions
             (shuffle (map #(merge % {:answered? false :points 100}) qs)))))

(defn make-level [num-questions]
  {:level 7
   :title "Maps"
   :questions (make-questions num-questions)})
