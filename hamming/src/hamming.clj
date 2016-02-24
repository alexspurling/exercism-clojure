(ns hamming)

(defn distance [dna1 dna2]
  (if (not= (count dna1) (count dna2))
    nil
    (count (filter false? (map = dna1 dna2)))))