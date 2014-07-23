(ns eon.core-test
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.levels :as levels]))

(defn contains-keys? [m keys]
  (every? #(contains? m %) keys))

(defn questions-contain-keys? [m keys]
  (every? #(contains-keys? % keys) (:questions m)))

(def level-maps [(levels/make-level 1)
                 (levels/make-level 2)
                 (levels/make-level 3)
                 (levels/make-level 4)])

(deftest levels-contain-expected-keys
  (let [keys [:level :questions :title :question-fn :curr-question :level]]
    (is (every? #(contains-keys? % keys) level-maps))))

(deftest questions-contain-expected-keys
  (let [keys [:question :answer :answered? :points]]
    (is (every? #(questions-contain-keys? % keys) level-maps))))
