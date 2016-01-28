(ns grade-school
  (:import (java.util TreeMap Map)))

(defn add [db name grade]
  "Adds a student to the database"
  (update db grade (fnil conj []) name))

(defn grade [db grade]
  "I just learnt how to document my functions"
  (get db grade []))

(defn sorted [db]
  "Returns the input map sorted by key and with each value sorted."
  (letfn [(map-values [m f] (zipmap (keys m) (map f (vals m))))]
    (TreeMap. ^Map (map-values db sort))))