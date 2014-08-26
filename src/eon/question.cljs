(ns eon.question)

(defrecord Question [question answer answered? points])

(defn make-question [question answer]
  (Question. question answer false 100))

(defn shuffle-and-take [qs num-questions]
  (vec (take num-questions (shuffle qs))))
