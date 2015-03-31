(ns ninjakoala.lamarck.data
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.set :as s]))

(def ^:private instance-key-mappings
  {:ECU :ecu
   :ebs_optimized :ebs-optimized?
   :enhanced_networking :enhanced-networking
   :instance_type :instance-type
   :linux_virtualization_types :linux-virtualization-types
   :network_performance :network-performance
   :vCPU :vcpu})

(def ^:private price-key-mappings
  {:mswinSQL :mswin-sql
   :mswinSQLWeb :mswin-sql-web})

(def ^:private vpc-key-mappings
  {:ips_per_eni :ips-per-eni
   :max_enis :max-enis})

(defn- double-or-nothing
  [price]
  (when (and (some? price) (not= price "N/A"))
    (Double/valueOf price)))

(defn- numberize-prices
  [prices]
  (into {} (map (fn [[k v]] (when-let [price (double-or-nothing v)] [k price])) (s/rename-keys prices price-key-mappings))))

(defn- sort-out-prices
  [pricing]
  (into {} (map (fn [[k v]] [k (numberize-prices v)]) pricing)))

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
