# portable date formatting using cljc.java-time 

an example of a problem formatting date values on nodejs.

first `npm install`

then start a clojure repl

then see the user.clj for how to start the tests.



the problem appears to be that cljs.java-time is using deprecated npm deps 
and I cannot find the right combination of old/new deps to make formatting work.