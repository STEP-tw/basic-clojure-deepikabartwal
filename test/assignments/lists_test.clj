(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "sum with two collection"
      (is ( = [3 7 11] (map' + [1 3 5] [2 4 6]))))
    )
  (testing "filter"
    (testing "filtering is Even"
      (is (= [2] (filter' even? [1 2 3]))))
    (testing "filtering number greater than 4"
      (is (= [ 5 6 7] (filter' (partial < 4) [1 3 4 5 6 7]))))
    ))