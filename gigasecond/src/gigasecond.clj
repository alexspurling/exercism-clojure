(ns gigasecond
  (:import (java.util Calendar)))

(defn calendar [year month day]
  (let [cal (Calendar/getInstance)]
    (.set cal year (dec month) day, 0, 0, 0)
    cal))

(defn cal-to-vec [cal]
  [(.get cal Calendar/YEAR)
   (inc (.get cal Calendar/MONTH))
   (.get cal Calendar/DAY_OF_MONTH)])

(defn from [year month day]
  (let [cal (calendar year month day)]
    (.add cal Calendar/SECOND 1e9)
    (cal-to-vec cal)))