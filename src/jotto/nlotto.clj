(ns jotto.nlotto
  (:gen-class)
  (:require [clj-http.client :as client]
            ;; [http.async.client :as http]
            [cheshire.core :refer :all :as json]))

;; 최근당첨
;; http://www.nlotto.co.kr/common.do?method=getLottoNumber
;; 회차지정
;; http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=596
;; ttp://www.nlotto.co.kr/common.do?method=topStoreLocation&rtlrId=

(client/get "http://nlotto.co.kr/result.do"
            {:query-params {"method" "getWin520"}})

(client/get "http://www.nlotto.co.kr/common.do"
            {:query-params {"method" "getLottoNumber"}})

(defn get-lotto-api-url
  ""
  [& [n]]
  (let [latest "http://www.nlotto.co.kr/common.do?method=getLottoNumber"]
    (str latest (if n (str "&drwNo=" n)))))

(defn get-json
  ""
  [& [n]]
  (get (client/get "http://www.nlotto.co.kr/common.do"
                   (if n
                     {:query-params {"method" "getLottoNumber" "drwNo" n}}
                     {:query-params {"method" "getLottoNumber"}}))
       :body)
  ;; (with-open [client (http/create-client)]
  ;;   (let [response (http/GET client (get-lotto-api-url n))]
  ;;     (-> response
  ;;         http/await
  ;;         http/string)))
  )

(defn get-lotto-number
  ""
  [& [n]]
  (json/parse-string (get-json n) true))

(defn print-lotto-number
  ""
  [& [n]]
  (let [rest-result (get-lotto-number n)
        no   (get rest-result :drwNo)
        date (get rest-result :drwNoDate)
        no1  (get rest-result :drwtNo1)
        no2  (get rest-result :drwtNo2)
        no3  (get rest-result :drwtNo3)
        no4  (get rest-result :drwtNo4)
        no5  (get rest-result :drwtNo5)
        no6  (get rest-result :drwtNo6)
        bno  (get rest-result :bnusNo)]
    (println (format
              "========
%s th
%s
%d %d %d %d %d %d + %d
"
              no date no1 no2 no3 no4 no5 no6 bno)))
  )


