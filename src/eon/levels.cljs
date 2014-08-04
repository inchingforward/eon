(ns eon.levels
  "Creates levels."
  (:require [eon.level-01 :as level-01]
            [eon.level-02 :as level-02]
            [eon.level-03 :as level-03]
            [eon.level-04 :as level-04]))

(defn make-levels [num-questions]
  "Builds a vector of level maps."
  [(level-01/make-level num-questions)
;   (level-02/make-level num-questions)
;   (level-03/make-level num-questions)
   (level-04/make-level num-questions)])
