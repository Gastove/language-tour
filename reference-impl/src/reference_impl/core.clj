(ns reference-impl.core
  (:require [clj-time.core :as time]
            [clj-time.format :as time-format]
            [clojure.string :as str]
            [clojure.java.io :as io])
  (:import [java.lang.management ManagementFactory]))

;; Reminder that our data looks like this
;; date|phone_number
;; 2016-12-20|093.419.0454
;; Thu, 08 Oct 2015 19:17:24 +0000|264.102.4584
;; 2016-08-06|002.037.2903
;; Sat, 03 Jun 2017 05:17:24 +0000|701.050.7842
;; 2016-03-15|(777) 556-0981
;; 2015-09-15|(373) 525-1922
;; Fri, 29 Jul 2016 08:17:24 +0000|1-507-988-1482
;; Thu, 26 May 2016 07:17:24 +0000|445.799.6042
;; 2017-02-03|(383) 821-2493

(defn get-vm-start-time
  []
  (.. (ManagementFactory/getRuntimeMXBean)
      (getStartTime)))

(def parsers
  (map time-format/formatters [:date :rfc822 :date-hour-minute-second]))

(def desired-fmt (time-format/formatters :date))

(def parse-many
  (apply time-format/formatter (cons (time/default-time-zone) parsers)))

(defn parse-dt
  [dt-str]
  (try
    (time-format/parse parse-many dt-str)
    (catch org.joda.time.IllegalInstantException e
      (.. (time-format/parse-local parse-many dt-str)
          (plusHours 3)
          (toDateTime)))))

(def phone-number-re
  #"\d-(\d{3})-(\d{3})-(\d{4})|(\d{3})\.(\d{3})\.(\d{4})|\((\d{3})\) (\d{3})-(\d{4})")

(defn parse-phone-number
  [pn-str]
  (->> (re-matches phone-number-re pn-str)
       (drop 1)
       (filter some?)))

(defn stringify-row [[dt pn]]
  (str (time-format/unparse desired-fmt dt) (str/join "-" pn) "\n"))

(defn read-row
  "In: pipe-delimited rows of date, phone number."
  [row]
  (let [[date phone-number] (str/split row #"\|")]
    [(parse-dt date) (parse-phone-number phone-number)]))

(defn process [in-file-uri out-file-uri]
  (with-open [rdr (io/reader in-file-uri)
              wrtr (io/writer out-file-uri :append true)]
    (doseq [row (drop 1 (line-seq rdr))]
      (let [new-row (read-row row)]
        (.write wrtr (stringify-row new-row))))))

(defn -main
  [& args]
  (let [app-start (System/currentTimeMillis)
        vm-start (get-vm-start-time)
        delay (- app-start vm-start)]
    (println "LET'S DO THIS THANG!")
    (process "/Users/gastove/Code/language-tour/data-generator/2017-05-22_random_data.csv" "/tmp/parsed.csv")
    (let [run-time (- (System/currentTimeMillis) app-start)]
      (println (str "Took " (/ delay 1000.0) " seconds to start, ran for " (/ run-time 1000.0) " seconds.")))))
