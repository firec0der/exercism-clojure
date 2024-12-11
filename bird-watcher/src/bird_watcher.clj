(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (get birds 6))

(defn inc-bird [birds]
  (assoc birds 6 (+ (today birds) 1)))

(defn day-without-birds? [birds]
  (->> birds
       (some #(= 0 %))
       boolean))

(defn n-days-count [birds n]
  (->> birds
       (take n)
       (reduce +)))

(defn busy-days [birds]
  (->> birds
       (filter #(<= 5 %))
       count))

(defn odd-week? [birds]
  (every? #{0 1} birds))
