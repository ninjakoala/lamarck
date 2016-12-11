(defproject com.ninjakoala/lamarck "1.0.13"
  :description "For classifying clouds (specifically Amazon's)"
  :url "https://github.com/ninjakoala/lamarck"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cheshire "5.6.3"]
                 [com.taoensso/encore "2.87.0"]
                 [org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]
                   :plugins [[lein-midje "3.2.1"]]}}
  :plugins [[lein-release "1.0.5"]]
  :lein-release {:deploy-via :clojars})
