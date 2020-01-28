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


