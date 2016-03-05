(ns roman-numerals)

(def decimal-to-roman
  {1 "I" 5 "V" 10 "X" 50 "L" 100 "C" 500 "D" 1000 "M"
   4 "IV" 9 "IX" 40 "XL" 90 "XC" 400 "CD" 900 "CM"})

;Find the largest known roman numeral value that is less than
;the given value
(defn largest-sub-value [n]
  (apply max (filter #(< % n) (keys decimal-to-roman))))

(defn numerals [n]
  (if (contains? decimal-to-roman n)
    ;If it's one of the known lookup value then use it
    (decimal-to-roman n)
    ;If not, subtract the largest possible known value
    (let [sub-value (largest-sub-value n)]
      (str (numerals sub-value)
           (numerals (- n sub-value))))))