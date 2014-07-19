(defproject eon "0.1.0-SNAPSHOT"
  :description "A game that tests ClojureScript evaluation comprehension."
  :url "http://eon.mikejanger.net"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [om "0.6.4"]
                 [prismatic/om-tools "0.2.2"]
                 [figwheel "0.1.3-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-figwheel "0.1.3-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "eon"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/js/eon.js"
                :output-dir "resources/public/js/out"
                :optimizations :none
                :source-map true}}]}

  :figwheel {
    :http-server-root "public"
    :css-dirs ["resources/public/css"]})
