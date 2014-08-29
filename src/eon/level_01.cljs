(ns eon.level-01
  "Basic evaluations:  things that evaluate to themselves."
  (:require [eon.question :refer [make-question]]))

(def strings ["\"eon\"" "\"clojure\"" "\"functional\"" "\"lisp\"" "\"quiz\""])

(def keywords [:color :year :price :title :name :a :b :c :keyword])

(def characters ["\\a" "\\b" "\\c" "\\d" "\\e" "\\f" "\\g" "\\h"])

(def numbers [42 23 2014 3.14 13 1 0])

(defn get-random-questions [num-questions]
  (->> (concat strings keywords characters numbers)
       (shuffle)
       (take num-questions)))

(defn make-questions [num-questions]
  (let [questions (get-random-questions num-questions)]
    (vec (map #(make-question % %) questions))))

(defn make-level [num-questions]
  {:level 1
   :title "The Thing Itself"
   :questions (make-questions num-questions)})
