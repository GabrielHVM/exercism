(ns cars-assemble)

(defn remove-faulty-cars
  "Given the percent of success rate of the production
  and the optimal-production,
  returns the optimal-production subtracted of the
  faulty cars"
  [success-rate optimal-production]
  (let [success-rate-multiplier (/ success-rate 100)]
    (* optimal-production success-rate-multiplier)))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [cars-per-hour 221
        optimal-production (double (* speed cars-per-hour))]
    (cond
      (<= speed 4) optimal-production
      (and (> speed 4) (< speed 9)) (remove-faulty-cars 90 optimal-production)
      (= speed 9) (remove-faulty-cars 80 optimal-production)
      (= speed 10) (remove-faulty-cars 77 optimal-production))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (let [cars-per-hour (production-rate speed)]
    (int (/ cars-per-hour 60))))
