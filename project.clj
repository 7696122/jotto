(defproject jotto "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.1.0"]
                 ;; [http.async.client "0.5.2"]
                 [cheshire "5.4.0"]

                 ;; LOGGING DEPS
                 ;; [org.clojure/tools.logging "0.2.4"]
                 ;; [org.slf4j/slf4j-log4j12 "1.7.1"]
                 ;; [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                 ;;                                    javax.jms/jms
                 ;;                                    com.sun.jmdk/jmxtools
                 ;;                                    com.sun.jmx/jmxri]]
                 ]
  :main ^:skip-aot jotto.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
