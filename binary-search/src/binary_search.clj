(ns binary-search)

(defn middle [s]
  (quot (count s) 2))

(defn vec-sorted? [v]
  (= v (sort v)))

;Possibly the ugliest clojure I've written so far
;I miss type-based overloading, pattern checking etc

(defmulti search-for
          (fn [x s]
            (cond
              (vector? s)
              (if (vec-sorted? s)
                :sorted-vector
                :unsorted-vector)
              (seq? s)
                :seq
              :default :default)))

(defmethod search-for :sorted-vector
  ([x s]
    (if (empty? s)
      (throw (RuntimeException. "not found"))
      (let [middle (middle s)
            mvalue (nth s middle)]
        (cond
          (= x mvalue) middle
          (< x mvalue) (search-for x (subvec s 0 middle))
          (> x mvalue)
          (+ (inc middle) ;we're looking in the second half so need to keep track of the index
             (search-for x (subvec s (inc middle) (count s)))))))))

(defmethod search-for :unsorted-vector [x s]
  (throw (IllegalArgumentException. (str "Vector must be sorted: " s))))

(defmethod search-for :seq [x s] (search-for x (vec s)))