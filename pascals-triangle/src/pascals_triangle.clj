(ns pascals-triangle)

(defn triangle-row [last-row]
  (concat [1N] (map + last-row (rest last-row)) [1N]))

(def triangle
  (iterate triangle-row [1N]))

(defn row [n]
  (nth triangle (dec n)))