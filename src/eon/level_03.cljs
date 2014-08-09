(ns eon.level-03
  "Nil.")

;; Examples:
;; (seq [])
;; (seq? [])
;; (nil? nil)
;; (nil? [])
;; (not nil)

(defn make-question []
  (let [result (rand-nth [nil false])]
    {:question result
     :answer result
     :answered? false
     :points 100}))

(defn make-questions [num-questions]
  (vec (take num-questions (repeatedly make-question))))

(defn make-level [num-questions]
  {:level 3
   :title "Nil"
   :questions (make-questions num-questions)})
