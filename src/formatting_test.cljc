(ns formatting-test
  (:require

    [clojure.test :refer [deftest is]]
    [cljc.java-time.local-date-time :as local-date-time]
    [cljc.java-time.format.date-time-formatter :as date-time-formatter]

    ; old/deprecated
    #?(:cljs ["js-joda" :as joda])
    #?(:cljs ["js-joda-timezone"])                          ; registers itself
    ; below are required by npm as peer deps
    #?(:cljs ["@js-joda/locale" :as joda-locale])
    #?(:cljs ["@js-joda/locale_en" :as joda-locale_en])

    ; newer (not deprecated) but not what cljc.java-time is built on
    ;["@js-joda/core" :as joda]
    ;["@js-joda/timezone"]
    ;["@js-joda/locale_en" :as joda-locale-en]
    ))

(def party-time (local-date-time/of 2000 1 1 0 0 0 0))

(deftest format-date-in-node

  ; illustrates the problem, with a fix described here...
  ; https://js-joda.github.io/js-joda/manual/formatting.html#formatting-with-locales
  ; but I cannot find the correct combo of npm deps to make this work

  #?(:cljs
     ;(js/console.log value)
     (let [formatter (-> joda/DateTimeFormatter
                         ;(.ofPattern "MM")                   ; works!
                         (.ofPattern "MMMM")                ; fails
                         (.withLocale joda-locale/UK)
                         )]
       (-> party-time
           (.format formatter)
           js/console.log)))
  )

(deftest format-date-in-jvm

  ; works great in clojure

  #?(:clj (is (= "January"
                 (-> (date-time-formatter/of-pattern "MMMM")
                     (date-time-formatter/format party-time))))))




