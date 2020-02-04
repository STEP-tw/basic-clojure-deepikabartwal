(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map'"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "sum with two collection"
      (is (= [3 7 11] (map' + [1 3 5] [2 4 6]))))
    )

  (testing "filter'"
    (testing "filtering is Even"
      (is (= [2] (filter' even? [1 2 3]))))
    (testing "filtering number greater than 4"
      (is (= [5 6 7] (filter' (partial < 4) [1 3 4 5 6 7]))))
    )

  (testing "reduce'"
    (testing "adding"
      (is (= 6 (reduce' + [1 2 3])))))

  (testing "count'"
    (testing "collection of length 4"
      (is (= 4 (count' [1 2 3 4]))))
    (testing "collection of length 0"
      (is (= 0 (count' []))))
    (testing "collection of length 6"
      (is (= 6 (count' '(1 2 3 4 5 6))))))

  (testing "reverse'"
    (testing "a coll of numbers"
      (is (= '(4 3 2 1) (reverse' [1 2 3 4])))
      )
    (testing "a collection of strings"
      (is (= '("cd" "ab") (reverse' ["ab" "cd"]))))
    (testing "on a map"
      (is (= '([3 4] [1 2]) (reverse' {1 2 3 4})))
      )
    (testing "on a number"
      (is (= nil (reverse' 1))))
    (testing "on a string"
      (is (= '(\d \c \b \a) (reverse' "abcd")))))

  (testing "every?'"
    (testing "when all elements satisfy the predicate"
      (is (true? (every?' even? [2 4 6 8]))))
    (testing "when all elements don't satisfy the predicate"
      (is (false? (every?' even? [ 1 2 3 4]))))
    (testing "for empty collection"
      (is (true? (every?' even? [])))))

  (testing "some?'"
    (testing "when some elements satisfy the predicate"
      (is (true? (some?' even? [1 2 3 4]))))
    (testing "When none of the elements satisfy the predicate"
      (is (false? (some?' even? [1 3 5 7]))))
    (testing "For empty list"
      (is (false? (some?' even? [])))))

  (testing "ascending?"
    (testing "when the collection is in ascending order"
      (is (true? (ascending? [1 2 3 4]))))
    (testing "when the collection isn't in ascending order"
      (is (false? (ascending? [1 2 5 4])))))

  (testing "russian doll"
    (testing "Wrapping numbers in a list"
      (is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3))))
    (testing "When nesting limit is one"
      (is (= [1 2 3 4] (russian-dolls [1 2 3 4] 1)))))

  (testing "sum of adjacent digits"
    (testing "sum of adjacent digit of positive integers"
      (is (= [3 5] (sum-of-adjacent-digits [1 2 3]))))
    (testing "sum adjacent digit with a few negative integers"
      (is (= [-1 1] (sum-of-adjacent-digits [1 -2 3])))))

  (testing "transpose"
    (testing "of 2 x 2 matrix"
      (is (= [[1 3] [2 4]] (transpose [[1 2] [3 4]])))))

  (testing "cross-product"
    (testing "when an element is common in two lists"
      (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]] (cross-product [1 2 3] [4 3 5]))))
    (testing "when no element is common"
      (is (= [[1 3] [1 4] [2 3] [2 4]] (cross-product [1 2] [3 4])))))

  (testing "muted thirds"
    (testing "for list of numbers more that 3"
      (is (= [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7]))))
    (testing "for less than three"
      (is (= [1 2] (muted-thirds [1 2])))))

  (testing "index of"
    (testing "element present in collection"
      (is (= 4 (index-of [1 2 3 4 5 6] 5))))
    (testing "element not-present in collection"
      (is (= -1 (index-of [1 2 3 4 5 6] 9)))))

  (testing "square of first number"
    (testing "non-empty collection"
      (is (= [16 16 16] (sqr-of-the-first [4 5 6])))))

  (testing "double up"
    (testing "with integer sequence"
      (is (= [1 1 2 2 3 3] (double-up [1 2 3])))))
  )