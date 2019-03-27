(ns tests.test-foo
  (:require ["puppeteer" :as p]
            [kitchen-async.promise :as kp]
            [cljs.test :as t]))

(t/deftest check-google
  (t/async
   done
   (kp/try
     (kp/let [browser (p/launch (clj->js {"args" ["--no-sandbox"]
                                          ;;disabel headless for fun
                                          "headless" false
                                          }))
              page (.newPage browser)]
       (.goto page "https://www.google.com/")
       (.waitForSelector page "input[type='text']")
       (.focus page "input[type='text']")
       (.type page "input[type='text']" "cstap"  #js {:delay 100})
       (.waitForSelector page "input[name='btnK']")
       (.click page "input[name='btnK']" )
       (.waitForSelector page "a[href*='cstap.com']")
       (.click page "a[href*='cstap.com']")
       (.waitForSelector page "a[href*='jobs']")
       (.click page "a[href*='jobs']")
       (t/is (= (.url page) "https://cstap.com/jobs/"))
       (.close browser)
       (t/is true)
       (done))
     (kp/catch js/Error e
       (js/console.error e)
       (t/is false)
       (done)
       (js/process.exit 1)))))

(comment
  (kp/let [browser (p/launch (clj->js {"args" ["--no-sandbox"]
                                       ;;disabel headless for fun
                                       "headless" false
                                       }))
           page (.newPage browser)]
    (.goto page "https://www.google.com/")
    (.waitForSelector page "input[type='text']")
    (.focus page "input[type='text']")
    (.type page "input[type='text']" "cstap"  #js {:delay 100})
    (.waitForSelector page "input[name='btnK']")
    (.click page "input[name='btnK']" )
    (.waitForSelector page "a[href*='cstap.com']")
    (.click page "a[href*='cstap.com']")
    (.waitForSelector page "a[href*='jobs']")
    (.click page "a[href*='jobs']")))
