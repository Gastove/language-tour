#lang racket

(require gregor
         csv-reading)

;; Data looks like this:
;; $ head data-generator/2016-06-16_random_data.csv
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
;; 2016-04-22T12:17:24|403.557.3331

;; Phone number regex:
;; [1-]?\(?(\d{3})\)?[\. -]?(\d{3})[\.-]?(\d{4})

(define target-csv
  (simplify-path "../data-generator/2016-06-16_random_data.csv"))

(define telephone-pattern #px"[1-]?\\(?(\\d{3})\\)?[\\. -]?(\\d{3})[\\.-]?(\\d{4})")

(define date-formats
  (list "yyyy-MM-dd"
        "yyyy-MM-dd'T'HH:mm:ss"
        "EEE, dd MMM yyyy HH:mm:ss ZZZ"))

(define (parse-telephone-no no-str)
  (let ([pn (rest (regexp-match telephone-pattern no-str))])
    (if (empty? pn)
        "na"
        (string-join pn ""))))

(define (handled-dt-parse dt p)
  (with-handlers
      ([exn:fail? (lambda (e) #f)])
    (parse-date dt p)))

(define (parse-dt dt-str)
  (let ([res (map (lambda (p) (handled-dt-parse dt-str p)) date-formats)])
    (first (filter (lambda (r) (not (false? r))) res))))

(define (parse-row row)
  (match-let ([(list dt-str pn-str) row])
    (let* ([dt (parse-dt dt-str)]
           [pn (parse-telephone-no pn-str)])
      (list dt pn))))

(define make-example-csv-reader
  (make-csv-reader-maker
   '((separator-chars #\|))))


;; Count the lines in this file
;; (println (foldl + 0 (csv-map (lambda (x) 1) (make-example-csv-reader (open-input-file target-csv)))))
