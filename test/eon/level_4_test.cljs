(ns eon.level-4-test
  "Tests for the arithmetic level."
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.level-04 :as level]
            [clojure.string :as str]))

(defn has-required-parts [question-str]
  (let [parts (filter #(not (str/blank? %)) (str/split question-str #""))]
    (is (= "(" (first parts)))
    (is (contains? #{"+" "-" "*" "/"} (second parts)))
    (is (contains? #{"0" "1" "2" "3" "4" "5" "6" "7" "8" "9"} (nth parts 2)))
    (is (contains? #{"0" "1" "2" "3" "4" "5" "6" "7" "8" "9"} (nth parts 3)))
    (is (= ")" (last parts)))))

(deftest forms-contain-op-and-two-nums
  (let [questions (take 10 (repeatedly level/make-question))]
    (is (every? #(has-required-parts (:question %)) questions))))
