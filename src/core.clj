(ns core
  (:require [hyperfiddle.rcf :as rcf :refer [tests]]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defn get-rand-ints-in-range*
  [start end]
  (cons (rand-nth (range start end)) (lazy-seq (get-rand-ints-in-range* start end))))

(defn get-rand-ints-in-range
  [start end qty]
  (take qty (get-rand-ints-in-range* start end)))

(def vm [{:name "Juan" :document 6465}
         {:name "Juan1" :document 62465}
         {:name "Maria" :document 26465}])

(->> vm
     (group-by :name)
     (reduce
      (fn [acc [k v]]
        (-> acc
            (update :names conj (:name (first v)))
            (update :documents conj (:document (first v)))))
      {:names []
       :documents []}))


(tests)


(comment
  (rcf/enable!)

  (get-rand-ints-in-range 60 72 10)

  (range 0 100 2)

  :rcf)