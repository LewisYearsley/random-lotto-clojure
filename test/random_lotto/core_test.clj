(ns random-lotto.core-test
  (:require [clojure.test :refer :all]
            [random-lotto.core :refer :all]))

(deftest generate-numbers-tests
  (testing "Length is 6"
    (is (count (generate-numbers [])) 6)))
