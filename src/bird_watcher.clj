(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today
  "Given the birds counter returns the amount of bird's visits today"
  [birds]
  (last birds))

(defn inc-bird
  "Given the birds counter increments the counter of today"
  [birds]
  (let [today-counter (peek birds)]
    (-> birds
        pop
        (conj (inc today-counter)))))

(defn day-without-birds?
  "Given the birds counter, checks if exists one day without birds"
  [birds]
  (boolean (some zero? birds)))

(defn n-days-count
  "Given the birds counter and n days, counts the number of birds in these n days"
  [birds n]
  (reduce + (take n birds)))

(defn busy-days
  "Given birds counter, checks if exist a day with greater or equals 5 birds"
  [birds]
  (reduce (fn [acc day-counter]
            (if (>= day-counter 5)
              (inc acc)
              acc)) 0 birds))

(defn odd-week?
  "Given a birds counter of week, checks if the week is a odd-week"
  [birds]
  (boolean (reduce (fn [actual-value next-value]
                     (case actual-value
                       0 (if (= next-value 1) next-value nil)
                       1 (if (= next-value 0) next-value nil)
                       nil)) birds))
  )
