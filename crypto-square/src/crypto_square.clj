(ns crypto-square
  (:require [clojure.string]))

(defn normalize-plaintext [s]
  (->> s
       (clojure.string/lower-case)
       (filter
         #(or (Character/isDigit %)
              (Character/isLetter %)))
       (apply str)))

(defn square-size [s]
  (int (Math/ceil (Math/sqrt (count s)))))

(defn plaintext-segments [s]
  (let [normalized (normalize-plaintext s)
        square (square-size normalized)]
    (map (partial apply str) (partition-all square normalized))))

(defn- ciphertext-segments [s]
  (loop [segments (plaintext-segments s) cipher []]
    (if (seq segments)
      (let [maxsize (apply max (map count segments))
            minsize (apply min (map count segments))
            ciphersegments (apply map str segments)
            completecipher (concat cipher ciphersegments)]
        (if (not= minsize maxsize)
          ; ciphersegments will only contain minsize elements
          ; of the input segments. Let's recur to add the remaining
          ; parts of the input
          (recur (filter seq (map #(drop minsize %) segments)) completecipher)
          completecipher))
    [])))

(defn ciphertext [s]
  (apply str (ciphertext-segments s)))

(defn normalize-ciphertext [s]
  (clojure.string/join " " (ciphertext-segments s)))