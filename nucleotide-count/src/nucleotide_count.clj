(ns nucleotide-count)

(defn count [n dna]
  (when-not (#{\G \A \C \T} n)
    (throw (IllegalArgumentException. "Invalid dna")))
  (clojure.core/count (filter (partial = n) dna)))

(defn nucleotide-counts [dna]
  {\G (count \G dna),
   \A (count \A dna),
   \C (count \C dna),
   \T (count \T dna)})