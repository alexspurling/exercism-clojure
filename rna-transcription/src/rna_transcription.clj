(ns rna-transcription)

(defn transcribe [l]
  (case l
    \G \C
    \C \G
    \T \A
    \A \U
    (assert false "Unexpected neucleotide")))

(defn to-rna [dna]
  (apply str (map transcribe dna)))
