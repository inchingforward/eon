(ns eon.level-1-test
  "Tests for the basic level."
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.level-01 :as level]
            [clojure.string :as str]))

(deftest level-1-questions-equal-answers
  (let [questions (take 10 (repeatedly level/make-question))]
    (is (every? #(= (:question %) (:answer %)) questions))))
