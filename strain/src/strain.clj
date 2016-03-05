(ns strain)

(defn retain [f coll]
  (for [x coll :when (f x)] x))

(defn discard [f coll]
  (retain (complement f) coll))