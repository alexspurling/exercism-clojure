(ns triangle)

(defn type [a b c]
  (cond
    (or (>= a (+ b c))
        (>= b (+ a c))
        (>= c (+ a b))) :illogical
    (= a b c) :equilateral
    (or (= a b)
        (= a c)
        (= b c)) :isosceles
    :default :scalene))