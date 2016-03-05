(ns prime-factors)

(defn of [n]
  (loop [n n d 2 divisors []]
    (if (= n 1)
      divisors
      (if (= 0 (mod n d))
        (recur (/ n d) d (conj divisors d))
        (recur n (inc d) divisors)))))