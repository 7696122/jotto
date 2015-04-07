(ns jotto.core
  (:gen-class)
  (:require [jotto.nlotto :as nlotto]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (nlotto/print-lotto-number))
