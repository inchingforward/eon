(ns eon.core-test
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.levels :as levels]))

(deftest level-contains-expected-keys
  (is (contains? (levels/make-level 1) :level)))
