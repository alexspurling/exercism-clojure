(ns sieve)

(defn- find-next-prime [primes curprime]
  (loop [n (inc curprime)]
    (if (>= n (alength primes))
      nil
      (if (true? (aget primes n))
        n
        (recur (inc n))))))

(defn sieve-array [n]
  (let [prime-array (boolean-array n true)]
    (aset prime-array 0 false)
    (aset prime-array 1 false)
    (loop [primes prime-array p 2]
      (doseq [c (range (* p p) n p)]
        (aset-boolean primes c false))
      (if-let [next-prime (find-next-prime primes p)]
        (recur primes next-prime)
        (vec primes)))))

(defn sieve [n]
  (keep-indexed #(if (true? %2) %1) (sieve-array (inc n))))