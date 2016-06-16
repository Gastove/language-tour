(ns data-generator.core
  (:gen-class)
  (:require [clj-time
             [core :as t]
             [format :as f]]
            [clojure.java.io :as io]))

;; This thing does a pretty simple job, simply and well: make a fake CSV.

(def charsets {:upper-alphas "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
               :lower-alphas "abcdefghijklmnopqrstuvwxyz"
               :nums "0123456789"
               :punct-and-spaces " -!,?:~_ \"'$%&"})

(def sep \|)

(defn make-rand-str
  [length candidate-chars]
  (loop [acc []]
    (if (= (count acc) length)
      (apply str acc)
      (recur (conj acc (rand-nth candidate-chars))))))

(def random-formats [:date-hour-minute-second
                     :rfc822
                     :date])

(def rand-intervals [t/months t/days t/hours])

(defn make-random-date-str []
  (let [modded-date (-> (t/now)
                        ((rand-nth [t/plus t/minus]) (t/hours (rand-int 24)))
                        ((rand-nth [t/plus t/minus]) (t/days (rand-int 30)))
                        ((rand-nth [t/plus t/minus]) (t/months (rand-int 12)))
                        )]
    (f/unparse (f/formatters (rand-nth random-formats)) modded-date)))

(def headers
  (->> ["date" "phone_number"]
       (interpose sep)
       (apply str)))

(def pn-formats ["(%s) %s-%s"
                 "%s.%s.%s"
                 "1-%s-%s-%s"])

(defn break-apart [pn]
  (let [ac (take 3 pn)
        first-three (take 3 (drop 3 pn))
        last-four (take-last 4 pn)]
    (map #(apply str %) [ac first-three last-four])))

(defn make-random-phone-number []
  (let [digits (make-rand-str 10 (charsets :nums))
        fmt (rand-nth pn-formats)]
    (apply format (cons fmt (break-apart digits)))))

(defn make-row []
  (let [d (make-random-date-str)
        pn (make-random-phone-number)]
    (str (apply str (interpose sep [d pn])) \newline)))

(defn make-file-name []
  (let [fmt (f/formatters :date)]
    (str (f/unparse fmt (t/now)) "_random_data.csv")))

(defn -main
  [& args]
  (println "Here we go!")
  (let [file-name (make-file-name)]
    (with-open [w (io/writer file-name)]
      (.write w (str headers \newline))
      (loop [row-cnt 0]
        (.write w (make-row))
        (if (> row-cnt 10000000)
          (println "All done!")
          (recur (inc row-cnt)))))))
