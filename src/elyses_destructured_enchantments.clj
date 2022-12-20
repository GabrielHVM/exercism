(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[first-card-of-deck]]
  first-card-of-deck)

(defn second-card
  "Returns the second card from deck."
  [[_ second-card-of-deck]]
  second-card-of-deck)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[first-card second-card & rest]]
  (-> rest
       (conj first-card)
       (conj second-card)
      vec))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[top-card-deck & rest]]
  (->> (vec rest)
       (conj [] top-card-deck)))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  )
