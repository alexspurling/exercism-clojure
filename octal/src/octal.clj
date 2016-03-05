(ns octal)

(defn- octal-digit [d]
  (- (int d) 48))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn- octal-value [digit power]
  (* digit (exp 8 power)))

(defn to-decimal [octal]
  (if (re-matches #"[0-7]*" octal)
    (loop [decimal 0 power 0 [d & octal] (reverse octal)]
      (if d
        (recur
          (+ decimal (octal-value (octal-digit d) power))
          (inc power)
          octal)
        decimal))
    0))