(ns user
  (:require [shadow.cljs.devtools.api :as shadow]))

(comment

  ; to start the watcher and auto-run the test
  (do
    (require '[shadow.cljs.devtools.api :as shadow])
    (require '[shadow.cljs.devtools.server :as server])
    (server/start!)
    (shadow/watch :test))

  ; to stop the watcher
  (shadow/stop-worker :test)

  )