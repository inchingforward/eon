(ns eon.question-test
  (:require-macros [cemerick.cljs.test :refer [deftest is]])
  (:require [cemerick.cljs.test :as t]
            [eon.question :as q]))

(deftest sanity-test
  (let [question (q/make-question "Question" "Answer")]
    (is (= "Question" (:question question)))
    (is (= "Answer" (:answer question)))
    (is (= false (:answered? question)))
    (is (= 100 (:points question)))))
