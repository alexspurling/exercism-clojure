(ns phone-number)

(defrecord PhoneNumber [area main1 main2])

(defn parse-phone-number [phonestr]
  (let [digits (apply str (filter #(Character/isDigit %) phonestr))
        [_ area main1 main2] (re-matches #"1?(\d\d\d)(\d\d\d)(\d\d\d\d)" digits)]
    (if area
      (PhoneNumber. area main1 main2)
      (PhoneNumber. "000" "000" "0000")))) ;;For some reason we return a number of 0s instead of nil

(defn number [phonestr]
  (let [pn (parse-phone-number phonestr)]
    (str (:area pn) (:main1 pn) (:main2 pn))))

(defn area-code [phonestr]
  (:area (parse-phone-number phonestr)))

(defn pretty-print [phonestr]
  (let [pn-record (parse-phone-number phonestr)]
        (str "(" (:area pn-record) ") " (:main1 pn-record) "-" (:main2 pn-record))))