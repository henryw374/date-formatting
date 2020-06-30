(ns formatting-test
  (:require
    [clojure.test :refer [deftest is]]
    [cljc.java-time.local-date-time :as local-date-time]
    [cljc.java-time.format.date-time-formatter :as date-time-formatter]))

(def party-time (local-date-time/of 2000 1 1 0 0 0 0))

(deftest format-date
  #?(; happy days
     :clj  (is (= "January"
                  (-> (date-time-formatter/of-pattern "MMMM")
                      (date-time-formatter/format party-time))))

     ; computer says no!
     :cljs (try
             (-> (date-time-formatter/of-pattern "MMMM")
                 (date-time-formatter/format party-time))
             (catch :default e
               (js/console.log e)))))




