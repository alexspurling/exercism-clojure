(ns leap)

(defn divisible-by [x n]
  (= 0 (mod x n)))

(defn leap-year? [year]
  (and
    (divisible-by year 4)
    (or (not (divisible-by year 100))
      (divisible-by year 400))))