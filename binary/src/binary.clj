(ns binary)

(defn- binary-digit [d]
  (if (= \1 d) 1 0))

(defn- binary-value [digit power]
  ;Could use Math/pow here if it was clearer
  (bit-shift-left digit power))

(defn to-decimal [binary]
  (loop [decimal 0 power 0 [d & binary] (reverse binary)]
    (if d
      (recur
        (+ decimal (binary-value (binary-digit d) power))
        (inc power)
        binary)
      decimal)))