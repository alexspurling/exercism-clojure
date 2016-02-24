(ns grains)

(defn exp [a n]
  (reduce * (repeat n (bigint a))))

(defn square [n]
  (exp 2 (dec n)))

(defn total []
  (dec (square 65)))
