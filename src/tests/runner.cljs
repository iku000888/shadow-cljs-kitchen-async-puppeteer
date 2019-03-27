(ns tests.runner
  (:require ["puppeteer" :as p]
            [tests.test-foo :as test-foo]
            [cljs.test :as t]))

(defn run-all []
  (t/run-tests 'tests.test-foo))
