(ns eon.core
  (:require [figwheel.client :as fw]))

(enable-console-print!)

(fw/watch-and-reload
 :jsload-callback (fn []
                    ;; (stop-and-start-my app)
                    ))

(println "Hello eon!")
