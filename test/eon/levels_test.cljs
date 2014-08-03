(ns eon.levels-test
  "Tests common to all levels."
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.levels :as lvls]))


(def questions-per-level 5)

(def levels (lvls/make-levels questions-per-level))

(defn contains-keys? [m keys]
  (every? #(contains? m %) keys))

(defn questions-contain-keys? [m keys]
  (every? #(contains-keys? % keys) (:questions m)))

(deftest levels-contain-expected-keys
  (let [keys [:level :title :questions]]
    (is (every? #(contains-keys? % keys) levels))))

(deftest questions-contain-expected-keys
  (let [keys [:question :answer :answered? :points]]
    (is (every? #(questions-contain-keys? % keys) levels))))

(deftest levels-have-correct-number-of-questions
  (is (every? #(= questions-per-level (count (:questions %)) levels))))
