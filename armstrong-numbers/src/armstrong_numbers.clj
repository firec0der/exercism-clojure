(ns armstrong-numbers)

(defn armstrong? [num]
  (let [len (count (str num))]
    (->> (str num)
         (map (fn [^Character char] (Character/digit char 10)))
         (map (fn [digit] (Math/pow digit len)))
         (reduce +)
         (int)
         (= num))))
