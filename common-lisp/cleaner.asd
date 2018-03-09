(defpackage cleaner-asd
  (:use :cl :asdf))

(defsystem cleaner
  :description "Taking a tour of Common Lisp"
  :version "0.0.1"
  :license "MIT"
  :class :package-inferred-system
  :depends-on ((:alexandria
                :cleaner))
  )
