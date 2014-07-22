(ns eon.core-test
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.levels :as levels]))

(deftest level-contains-expected-keys
  (let [level (levels/make-level 1)]
    (is (contains? level :level))
    (is (contains? level :questions))
    (is (contains? level :title))
    (is (contains? level :question-fn))
    (is (contains? level :curr-question))
    (is (contains? level :level))))
