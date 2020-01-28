(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2)))
    (testing " zero denominator"
      (is (= :infinity (informative-divide 3 0))))))

(deftest raja-harishchandra
  (testing "when given true"
    (is (harishchandra true)))
  (testing "when given false"
    (is (nil? (harishchandra false))))
  (testing "when given nil"
    (is (nil? (harishchandra nil))))
  (testing "when given a number"
    (is (= 2 (harishchandra 2))))
  (testing "when given a string"
    (is (= "abc" (harishchandra "abc"))))
  (testing "when given zero"
    (is (zero? (harishchandra 0)))))

(deftest dharmaraja-yudhishtra
  (testing "when given true"
    (is (yudishtira true)))
  (testing "when given false"
    (is (= :ashwathama (yudishtira false))))
  (testing "when given nil"
    (is (= :ashwathama (yudishtira nil))))
  (testing "when given a number"
    (is (= 13 (yudishtira 13))))
  (testing "when given zero"
    (is (zero? (yudishtira 0)))))

(deftest duplicating-first
  (testing "idk what to write"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "when given empty coll"
    (is (nil? (duplicate-first []))))
  (testing "when first element is nil"
    (is (= [nil nil 1 2] (duplicate-first [nil 1 2])))))

(deftest five-point-to-someone
  (testing "when second param is 5"
    (is (= :chetan-bhagat (five-point-someone 2 5))))
  (testing "when first param is 5"
    (is (= :satan-bhagat (five-point-someone 5 2))))
  (testing "when first param is greater"
    (is (= :greece (five-point-someone 6 4))))
  (testing "when first param is smaller"
    (is (= :universe (five-point-someone 4 6)))))

(deftest conditions-apply-test
  (testing "for durga"
    (is (= :durga (conditions-apply [:a :b :c :d]))))
  (testing "for tuntun"
    (is (= :tuntun (conditions-apply [3]))))
  (testing "for wonder woman"
    (is (= :wonder-woman (conditions-apply [1 2 3 4]))))
  (testing "for cleopatra"
    (is (= :cleopatra (conditions-apply [[0 1] [2 3] [4 5]])))))

(deftest repeat-and-truncate-test
  (testing "repeat and truncate less than twice the length of coll"
    (is (= [0 1 2 0] (repeat-and-truncate (range 3) true true 4))))
  (testing "repeat and truncate more than twice the length of coll"
    (is (= [0 1 2 0 1 2] (repeat-and-truncate (range 3) true true 6)))))

(deftest order-in-words-test
  (testing "when x is greater than y and y is greater than z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "when x is greater than y and z is greater than x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "when x, y and z are in ascending order"
    (is (= [:z-greater-than-x] (order-in-words 3 4 5) ))))