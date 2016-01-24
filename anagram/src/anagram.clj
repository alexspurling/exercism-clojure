(ns anagram)

(defn anagram? [x y]
  (let [xlower (.toLowerCase x) ylower (.toLowerCase y)]
    (and
      (= (sort xlower) (sort ylower))
      (not= xlower ylower))))

(defn anagrams-for [word possible-anagrams]
  (filter #(anagram? word %) possible-anagrams))