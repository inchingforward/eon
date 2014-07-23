(defproject eon "0.1.0-SNAPSHOT"
  :description "A game that tests ClojureScript evaluation comprehension."
  :url "http://eon.mikejanger.net"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [om "0.6.4"]
                 [prismatic/om-tools "0.2.2"]
                 [figwheel "0.1.3-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-figwheel "0.1.3-SNAPSHOT"]
            [com.cemerick/clojurescript.test "0.2.3"]]

  :cljsbuild {
    :builds {

      :production {
        :source-paths ["src"]
        :compiler {
          :output-to "resources/public/js/eon.js"
          :optimizations :advanced}}

      :testing {
        :source-paths ["src" "test"]
        :compiler {
          :output-to "target/testing/eon-test.js"
          :optimizations :simple}}}

    :test-commands {"unit" ["phantomjs" :runner "target/testing/eon-test.js"]}}

  :figwheel {
    :http-server-root "public"
    :css-dirs ["resources/public/css"]})
