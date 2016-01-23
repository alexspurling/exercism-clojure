(ns word-count)

(defn split-words [input] (clojure.string/split input #"[^\w]+"))

(defn increment-freq [m i]
  (assoc m i (inc (get m i 0))))

(defn freq [list]
  (reduce increment-freq {} list))

(defn word-count [input]
  (freq (split-words (.toLowerCase input))))
