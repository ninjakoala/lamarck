(ns ninjakoala.lamarck-test
  (:require [midje.sweet :refer :all]
            [ninjakoala.lamarck :refer :all]))

(fact "that there are some instances"
      (count instances) =not=> 0)

(fact "that we're retrieving the right instances"
      (instance "c3.large") => (contains {:instance-type "c3.large"}))
