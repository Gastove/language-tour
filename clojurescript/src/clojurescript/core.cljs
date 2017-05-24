(ns clojurescript.core
  (:require [cljs.nodejs :as node]
            [cljs.core.async :as async]
            [clojure.string :as str]
            [cljs-time.core :as time]
            [cljs-time.format :as fmt])
  (:require-macros
   [cljs.core.async.macros :as async-macros]))

;; Reminder that our data looks like this
;; date|phone_number
;; 2016-12-20|093.419.0454
;; Thu, 08 Oct 2015 19:17:24 +0000|264.102.4584
;; 2016-08-06|002.037.2903
;; Sat, 03 Jun 2017 05:17:24 +0000|701.050.7842
;; 2016-03-15|(777) 556-0981
;; 2015-09-15|(373) 525-1922
;; Fri, 29 Jul 2016 08:17:24 +0000|1-507-988-1482
;; Thu, 26 May 2016 07:17:24 +0000c|445.799.6042
;; 2017-02-03|(383) 821-2493

(node/enable-util-print!)

(def read-line (node/require "readline"))
(def fs (node/require "fs"))

(defn open-line-reader [input]
  (.createInterface read-line (clj->js {:input input})))

(defn parse-line [line]
  (str/split line #"\|"))

(def phone-number-re
  #"\d-(\d{3})-(\d{3})-(\d{4})|(\d{3})\.(\d{3})\.(\d{4})|\((\d{3})\) (\d{3})-(\d{4})")

(defn parse-phone-number
  [pn-str]
  (->> (re-matches phone-number-re pn-str)
       (drop 1)
       (filter some?)))

(def date-formatter (fmt/formatters :date))
(def date-time-formatter (fmt/formatters :date-hour-minute-second))
(def rfc822-formatter (fmt/formatters :rfc822))

(defn parse-date
  [date-str]
  (cond
    (re-find #"[A-Za-z]{3}" date-str) (fmt/parse rfc822-formatter date-str) ; Parse as an RFC822
    (re-find #"T" date-str) (fmt/parse date-time-formatter date-str)  ; Parse as date-hour-minute-second
    :else (fmt/parse date-formatter date-str)                         ; Parse ISO
    ))

(defn line-processor
  [line]
  (let [[dt pn] (parse-line line)
        parsed-dt (parse-date dt)
        parsed-pn (parse-phone-number pn)]
    [parsed-dt parsed-pn]))

(defn stringify-line
  [[dt pn]]
  (let [dt-str (fmt/unparse date-formatter dt)
        pn-str (str/join "-" pn)]
    (str dt-str "," pn-str \newline)))

(defn read-in-file [path]
  (let [chan (async/chan 1000000 (map line-processor))
        input (.createReadStream fs path)
        rl (open-line-reader input)]
    (.on rl "line" #(async-macros/go (async/>! chan %)))
    (.on rl "close" #(async-macros/go (async/>! chan nil)))
    chan))

(defn -main []
  (println "EEE?")
  (let [read-chan (read-in-file "/Users/rossdonaldson/Code/personal/language-tour/data-generator/2017-05-24_random_data.csv")
        outfile (.openSync fs "/tmp/parsed.csv" "a")]
    (async-macros/go-loop []
      (let [line (async/<! read-chan)]
        (.writeSync fs outfile (stringify-line line)))
      (recur))
    (println "EEE!")))

(set! *main-cli-fn* -main)
