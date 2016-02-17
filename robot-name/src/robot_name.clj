(ns robot-name)

(defn random-char []
  (char (rand-nth (range 65 92))))

(defn random-digit []
  (rand-int 10))

(defn random-str-of [n fn]
  (apply str (repeatedly n fn)))

(defn random-robot-name []
  (str (random-str-of 2 random-char) (random-str-of 3 random-digit)))

(defn robot []
  (atom {:name (random-robot-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (random-robot-name)))