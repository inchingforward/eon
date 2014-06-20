(defproject eon "0.1.0-SNAPSHOT"
  :description "A game that teaches Clojure evaluation."
  :url "http://mikejanger.net"

  :dependencies [[org.clojure/clojure "1.5.1"]
                [org.clojure/clojurescript "0.0-2197"]
                [figwheel "0.1.3-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-figwheel "0.1.3-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "eon"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/js/compiled/eon.js"
                :output-dir "resources/public/js/compiled/out"
                :optimizations :none
                :source-map true}}]})
