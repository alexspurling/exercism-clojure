(ns bob
  (:require [clojure.string :refer [blank?]]))

(defn all-letters-caps? [input]
  (and
    (= input (.toUpperCase input))
    (not= input (.toLowerCase input))))

(defn response-for [said]
  (cond
    (blank? said) "Fine. Be that way!"
    (all-letters-caps? said) "Whoa, chill out!"
    (.endsWith said "?") "Sure."
    :else "Whatever."))