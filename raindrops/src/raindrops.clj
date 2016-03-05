(ns raindrops)

(defn prime-factors [n]
  (loop [n n d 2 divisors []]
    (if (= n 1)
      divisors
      (if (= 0 (mod n d))
        (recur (/ n d) d (conj divisors d))
        (recur n (inc d) divisors)))))

(defn in?
  "true if coll contains elm"
  [coll elm]
  (some #(= elm %) coll))

(defn- has-prime-factor [n f]
  (in? (prime-factors n) f))

(defn convert [n]
  (let [pling (has-prime-factor n 3)
        plang (has-prime-factor n 5)
        plong (has-prime-factor n 7)]
    (if (or pling plang plong)
      (str
        (when pling "Pling")
        (when plang "Plang")
        (when plong "Plong"))
      (str n))))
