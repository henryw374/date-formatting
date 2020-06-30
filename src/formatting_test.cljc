(ns formatting-test
  (:require
    [clojure.test :refer [deftest is]]
    [cljc.java-time.local-date-time :as local-date-time]
    [cljc.java-time.format.date-time-formatter :as date-time-formatter]
    #?(:cljs ["@js-joda/locale_en-us" :as js-joda-locale])))

(def party-time (local-date-time/of 2000 1 1 0 0 0 0))

(deftest format-date
  (is (= "January"
        (-> (date-time-formatter/of-pattern "MMMM")
            (date-time-formatter/with-locale #?(:clj (java.util.Locale/getDefault)
                                                :cljs (try
                                                        (some->
                                                          (goog.object/get js-joda-locale "Locale")
                                                          (goog.object/get "US"))
                                                        (catch js/Error e))))
            (date-time-formatter/format party-time)))))


(comment 
  
  (clojure.test/run-all-tests)
  )

