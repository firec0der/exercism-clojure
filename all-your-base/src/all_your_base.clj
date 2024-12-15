(ns all-your-base)

(defn- pow-int [base exp]
  (loop [result 1, e exp]
    (if (zero? e)
      result
      (recur (* result base) (dec e)))))

(defn- to-decimal [from n-list]
  (let [length (count n-list)]
    (->> n-list
         (map-indexed
          (fn [i n]
            (* n (pow-int from (- length 1 i)))))
         (reduce +))))

(defn- from-decimal [to num]
  (->> num
       (iterate #(quot % to))
       (take-while pos?)
       (map #(mod % to))
       (reverse)))

(defn convert [from list to]
  (cond
    (or (<= from 1) (<= to 1)) nil
    (empty? list) []
    (every? zero? list) [0]
    (some neg? list) nil
    (some #(>= % from) list) nil
    :else (->> list
               (to-decimal from)
               (from-decimal to))))
