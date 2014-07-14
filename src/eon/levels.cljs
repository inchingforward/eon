(ns eon.levels
  "Creates levels."
  (:require [eon.level-01 :as level-01]
            [eon.level-02 :as level-02]
            [eon.level-03 :as level-03]))

(def questions-per-level 5)

(def levels
  {1 level-01/level
   2 level-02/level
   3 level-03/level})

(defn make-level
  "Creates a level map based on the given leven number."
  [level-num]
  (let [level (get levels level-num)]
    (merge level
           {:questions
             (take questions-per-level (repeatedly (:question-fn level)))})))
