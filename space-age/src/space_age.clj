(ns space-age)

(defn on-earth [sec]
  (double (/ sec 31557600)))

(defn on-mercury [sec]
  (double (/ (on-earth sec) 0.2408467)))

(defn on-venus [sec]
  (double (/ (on-earth sec) 0.61519726)))

(defn on-mars [sec]
  (double (/ (on-earth sec) 1.8808158)))

(defn on-jupiter [sec]
  (double (/ (on-earth sec) 11.862615)))

(defn on-saturn [sec]
  (double (/ (on-earth sec) 29.447498)))

(defn on-uranus [sec]
  (double (/ (on-earth sec) 84.016846)))

(defn on-neptune [sec]
  (double (/ (on-earth sec) 164.79132)))