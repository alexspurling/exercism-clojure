(ns trinary)

(defn- trinary-digit [d]
  (case d
    \0 0
    \1 1
    \2 2
    0))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn- trinary-value [digit power]
  (* digit (exp 3 power)))

(defn to-decimal [trinary]
  (if (re-matches #"[0-2]*" trinary)
    (loop [decimal 0 power 0 [d & trinary] (reverse trinary)]
      (if d
        (recur
          (+ decimal (trinary-value (trinary-digit d) power))
          (inc power)
          trinary)
        decimal))
    0))