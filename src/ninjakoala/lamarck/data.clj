(ns ninjakoala.lamarck.data
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.set :as s]))

(defn- numberize-prices
  [prices]
  (into {} (map (fn [[k v]] [k (Double/valueOf v)]) prices)))

(defn- sort-out-prices
  [pricing]
  (into {} (map (fn [[k v]] [k (numberize-prices v)]) pricing)))

(def ^:private instance-key-mappings
  {:ECU :ecu
   :ebs_optimized :ebs-optimized?
   :instance_type :instance-type
   :network_performance :network-performance
   :vCPU :vcpu})

(def ^:private vpc-key-mappings
  {:ips_per_eni :ips-per-eni
   :max_enis :max-enis})

(defn- adjust-instance
  [instance]
  (-> (s/rename-keys instance instance-key-mappings)
      (update-in [:pricing] sort-out-prices)
      (update-in [:vpc] #(s/rename-keys % vpc-key-mappings))))

(defonce raw-instances
  (map adjust-instance (json/parse-string (slurp (io/resource "instances.json")) true)))

(defn- map-by-instance-name
  [instances]
  (into {} (map (fn [i] [(:instance-type i) i]) instances)))

(defonce instances-by-name
  (map-by-instance-name raw-instances))
