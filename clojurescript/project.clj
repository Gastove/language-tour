(defproject clojurescript "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.542"]
                 [org.clojure/core.async  "0.3.442"]
                 [com.andrewmcveigh/cljs-time "0.5.0"]]

  :plugins [[lein-cljsbuild "1.1.6" :exclusions [[org.clojure/clojure]]]]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :compiler {:main clojurescript.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/clojurescript.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map true
                           :target :nodejs
                           ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                           ;; https://github.com/binaryage/cljs-devtools
                           ;; :preloads [devtools.preload]
                           }}

               {:id "prod"
                :source-paths ["src"]
                :compiler {:main clojurescript.core
                           :output-to "target/cli.js"
                           :output-dir "target/cli_prod"
                           :target :nodejs
                           :source-map "target/source-map.js"}}
               ]}


  ;; setting up nREPL for Figwheel and ClojureScript dev
  ;; Please see:
  ;; https://github.com/bhauman/lein-figwheel/wiki/Using-the-Figwheel-REPL-within-NRepl
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.2"]
                                  [figwheel-sidecar "0.5.10"]
                                  [com.cemerick/piggieback "0.2.1"]]

                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   ;; need to add the compliled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}})
