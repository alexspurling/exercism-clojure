(ns meetup
  (:import (java.util Calendar)))

(defn calendar [year month day]
  (let [cal (Calendar/getInstance)]
    (.set cal year (dec month) day, 0, 0, 0)
    cal))

(defn cal-to-vec [cal]
  [(.get cal Calendar/YEAR)
   (inc (.get cal Calendar/MONTH))
   (.get cal Calendar/DAY_OF_MONTH)])

(defn cal-range [year month]
  (let [first-cal (calendar year month 1)
        last-day (.getActualMaximum first-cal (Calendar/DAY_OF_MONTH))]
  (map #(calendar year month %) (range 1 (inc last-day)))))

(def days [:sunday :monday :tuesday :wednesday :thursday :friday :saturday])

(defn dow-int-to-key [dowint]
  (nth days (dec dowint)))

(defn isday [cal dow]
  (= dow (dow-int-to-key (.get cal Calendar/DAY_OF_WEEK))))

(defn dows [month year dow]
  (let [calrange (cal-range year month)
        dows-cal (filter #(isday % dow) calrange)]
    (map cal-to-vec dows-cal)))

(defn first-dow [month year dow]
  (first (dows month year dow)))

(defn last-dow [month year dow]
  (last (dows month year dow)))

(defn second-dow [month year dow]
  (nth (dows month year dow) 1))

(defn third-dow [month year dow]
  (nth (dows month year dow) 2))

(defn fourth-dow [month year dow]
  (nth (dows month year dow) 3))

(defn teenth-dow [month year dow]
  (first
    (filter (fn [[y m d]] (and (>= d 13) (<= d 19)))
            (dows month year dow))))

(defn meetup [month year dow occurence]
  (case occurence
    :teenth (teenth-dow month year dow)
    :first (first-dow month year dow)
    :second (second-dow month year dow)
    :third (third-dow month year dow)
    :fourth (fourth-dow month year dow)
    :last (last-dow month year dow)))