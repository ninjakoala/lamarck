(ns ninjakoala.lamarck
  (:require [ninjakoala.lamarck.data :refer [instances-by-name raw-instances]]))

(defonce instances
  (vals instances-by-name))

(defn instance
  [name]
  (get instances-by-name name))
