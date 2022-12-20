(ns interest-is-interesting)

(defn interest-rate
  "Given the balance, calculates the interest-rate of the balance"
  [balance]
  (cond
    (< balance 0M) -3.213
    (and (>= balance 0M) (< balance 1000M)) 0.5
    (and (>= balance 1000M) (< balance 5000M)) 1.621
    (>= balance 5000M) 2.475))

(defn annual-balance-update
  "Given a balance, update the annual balance"
  [balance]
  (let [interest-rate-amount (if (>= balance 0)
                               (partial * balance)
                               (partial * (- balance)))]
    (-> (interest-rate balance)
        bigdec
        (/ 100)
        interest-rate-amount
        (+ balance))))

(defn amount-to-donate
  "Given a balance and a tax free percentage, calcs the ammount to donate"
  [balance tax-free-percentage]
  (let [tax-free (* balance (/ tax-free-percentage 100))]
    (if (> balance 0)
      (int (* 2 tax-free))
      0)))
