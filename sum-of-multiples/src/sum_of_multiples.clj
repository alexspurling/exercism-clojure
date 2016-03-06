(ns sum-of-multiples)

(defn- multiple-of [of n]
  (some #(zero? (mod n %)) of))

(def sum (partial reduce +))

(defn sum-of-multiples
  ([upto] (sum-of-multiples [3 5] upto))
  ([of upto]
   (sum (filter (partial multiple-of of) (range upto)))))