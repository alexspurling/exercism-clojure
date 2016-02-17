(ns etl (:require [clojure.string]))

(defn add-scores [scores score items]
  (into scores (for [item items]
                 [(clojure.string/lower-case item) score])))

(defn etl/transform [scores]
  (reduce (fn [score-map [score items]]
            (add-scores score-map score items))
          {}
          scores))