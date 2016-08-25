(defproject eon "0.1.0-SNAPSHOT"
  :description "A game that tests Clojure evaluation comprehension."
  :url "http://eon.mikejanger.net"

  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.225"]
                 [reagent "0.4.2"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [com.cemerick/clojurescript.test "0.2.3"]]

  :cljsbuild {
    :builds {

      :production {
        :source-paths ["src"]
        :compiler {
          :output-to "resources/public/js/eon.js"
          :output-dir "resources/public/js/out"
          :optimizations :none}}

      :testing {
        :source-paths ["src" "test"]
        :compiler {
          :output-to "target/testing/eon-test.js"
          :optimizations :simple}}}

    :test-commands {"unit" ["phantomjs" :runner "target/testing/eon-test.js"]}})
