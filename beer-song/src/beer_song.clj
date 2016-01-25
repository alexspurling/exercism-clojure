(ns beer-song)

(defn verse [num]
  (cond
    (>= num 3) (str num
                    " bottles of beer on the wall, "
                    num
                    " bottles of beer.\n"
                    "Take one down and pass it around, "
                    (dec num)
                    " bottles of beer on the wall.\n")
    (= num 2) (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
                   "Take one down and pass it around, 1 bottle of beer on the wall.\n")
    (= num 1) (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
                   "Take it down and pass it around, no more bottles of beer on the wall.\n")
    (= num 0) (str "No more bottles of beer on the wall, no more bottles of beer.\n"
                   "Go to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn sing
  ([from] (sing from 0))
  ([from to]
    (apply str
           (clojure.string/join "\n"
                                (map verse (range from (dec to) -1))))))