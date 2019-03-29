(ns random-lotto.core
  (:gen-class))

(defn generate-numbers
  "Generates the random collection of numbers"
  [generated]    
  (let [max 59]
    (if (= (count generated) 6)
      (sort generated)
      (generate-numbers 
        (let [num (+ 1 (rand-int max))]
          (if (contains? generated num)
            generated
            (conj generated num)))))))

(defn -main
  "Prints generated numbers to the console"
  [& args]
  (println (generate-numbers [])))
