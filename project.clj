(defproject dev.gethop/session.cognito "0.1.0-SNAPSHOT"
  :description "Re-frame library for session management using AWS Cognito"
  :url "http://example.com/FIXME"
  :license {:name "Mozilla Public License 2.0"
            :url "https://www.mozilla.org/en-US/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [re-frame "1.2.0"]
                 [cljsjs/amazon-cognito-identity-js "5.2.8-0"]]
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]
  :aliases {"fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]}
  :profiles {:dev [:project/dev :profiles/dev]
             :repl {:repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}
             :profiles/dev {}
             :project/dev {:dependencies [[com.bhauman/figwheel-main "0.2.17"]
                                          [com.bhauman/rebel-readline-cljs "0.1.4"]
                                          [cider/piggieback "0.5.1"]]
                           :resource-paths ["target"]
                           :clean-targets ^{:protect false} ["target"]
                           :plugins [[jonase/eastwood "1.2.3"]
                                     [lein-cljfmt "0.8.0"]
                                     [day8.re-frame/re-frame-10x "1.2.2"]]}
             :eastwood {:linters [:all]
                        :exclude-linters [:keyword-typos
                                          :boxed-math
                                          :non-clojure-file
                                          :unused-namespaces
                                          :performance]
                        :debug [:progress :time]}})
