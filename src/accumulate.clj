(ns accumulate)

#_(defn accumulate [function coll]
  (reduce (fn [new-coll item-coll]
            (->> item-coll
                 function
                 (conj new-coll))) [] coll))

(defn accumulate
  ([function coll]
   (accumulate [] function coll))
  ([new-coll function coll]
   (if (empty? coll)
     new-coll
     (let [first-item (first coll)
           coll-with-new-item (conj new-coll (function first-item))]
       (recur coll-with-new-item function (rest coll))))))