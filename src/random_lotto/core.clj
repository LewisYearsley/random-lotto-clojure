(ns random-lotto.core
  (:gen-class))

(defn in 
  "Checks if a value is in a collection"
  [collection value]
    (some #(= value %) collection))

(defn stringify
  "Turns the generated numbers into a friendly string"
  [collection]
    (apply str 
      (map #(str " " %) collection)))

(defn generate-numbers
  "Generates the random collection of numbers"
  [generated]    
  (let [max 59]
    (if (= (count generated) 6)
      (stringify (sort generated))
      ;given that this is tail recursion it shouldn't overflow the stack      
      (generate-numbers 
        (let [num (+ 1 (rand-int max))]          
          (if (in generated num)
            generated
            (conj generated num)))))))

(defn -main
  "Prints generated numbers to the console"
  [& args]
  (println (generate-numbers [])))
