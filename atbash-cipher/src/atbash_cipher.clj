(ns atbash-cipher
  (:require [clojure.string]))

(defn- subsitute [c]
  (if (and (>= (int c) 97) (<= (int c) 122))
    (char (- 122 (- (int c) 97)))
    c))

(defn- remove-punctuation [s]
  (filter #(or (Character/isDigit %) (Character/isLetter %)) s))

(defn- group-by-5 [s]
  (clojure.string/join
    " "
    (map (partial apply str) (partition-all 5 s))))

(defn encode [s]
  (->> s
       clojure.string/lower-case
       remove-punctuation
       (map subsitute)
       group-by-5))