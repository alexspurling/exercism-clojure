(ns allergies)

(def allergens [:eggs :peanuts :shellfish :strawberries
                :tomatoes :chocolate :pollen :cats])

(defn allergies [x]
  (map allergens (filter #(bit-test x %) (range (count allergens)))))

(defn allergic-to? [x allergen]
  ((set (allergies x)) allergen))