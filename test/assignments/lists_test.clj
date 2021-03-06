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

  (testing "Union"
    (testing "with no common elements in both collection"
      (is (= [1 2 3 4 5 6] (union [1 2 3] [4 5 6]))))
    (testing "with some common element"
      (is (= [1 2 3 4 5] (union [1 2 3] [3 4 5])))))

  (testing "Difference"
    (testing "with no common elements in both collection"
      (is (= [4 5 6] (difference [1 2 3] [4 5 6]))))
    (testing "with some common element"
      (is (= [4 5] (difference [1 2 3] [3 4 5])))))

  (testing "Points around origin"
    (is (= '([-1 -1]
             [-1 0]
             [-1 1]
             [0 -1]
             [0 1]
             [1 -1]
             [1 0]
             [1 1]) points-around-origin)))

  (testing "Third or fifth"
    (testing "with single item"
      (is (= ["I"] (third-or-fifth ["I"]))))
    (testing "with collection containing 4 items - last index is 3"
      (is (= [1 4] (third-or-fifth [1 2 3 4]))))
    (testing "with collection containing 6 items - last index is 5"
      (is (= [1 4 6] (third-or-fifth [1 2 3 4 5 6])))))

  (testing "Palindrome?"
    (testing "with empty collection"
      (is (true? (palindrome? []))))
    (testing "with palindrome list"
      (is (true? (palindrome? [1 2 1]))))
    (testing "with string"
      (is (true? (palindrome? "NaN"))))
    (testing "not a palindrome"
      (is (false? (palindrome? [1 2 3])))))

  (testing "distinct'"
    (testing "with no duplicates"
      (is (= [1 2 3] (distinct' [1 2 3]))))
    (testing "with duplicates"
      (is (= [1 2 3] (distinct' [1 1 2 3 2])))))

  (testing "dedupe'"
    (testing "with no duplicates"
      (is (= [1 2 3] (dedupe' [1 2 3]))))
    (testing "with duplicates but not consecutive"
      (is (= [1 2 3 1] (dedupe' [1 2 3 1]))))
    (testing "with consecutive duplicates"
      (is (= [1 2 3] (dedupe' [1 1 2 3 3])))))

  (testing "max-three-digit-sequence"
    (testing "middle term max"
      (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0]))))
    (testing "end term max"
      (is (= [-1 2 3] (max-three-digit-sequence [1 2 -1 2 3])))))

  (testing "Split comb"
    (testing "with even sequence"
      (is (= [1 3 2 4] (split-comb [1 2 3 4]))))
    (testing "with odd sequence"
      (is (= [1 3 2 4 5] (split-comb [1 2 3 4 5])))))

  (testing "Suduko"
    (testing "correct grid"
      (is (true? (validate-sudoku-grid
                   [[4 3 5 2 6 9 7 8 1]
                    [6 8 2 5 7 1 4 9 3]
                    [1 9 7 8 3 4 5 6 2]
                    [8 2 6 1 9 5 3 4 7]
                    [3 7 4 6 8 2 9 1 5]
                    [9 5 1 7 4 3 6 2 8]
                    [5 1 9 3 2 6 8 7 4]
                    [2 4 8 9 5 7 1 3 6]
                    [7 6 3 4 1 8 2 5 9]]))))
    (testing "incorrect grid"
      (is (false? (validate-sudoku-grid
                    [[4 4 5 2 6 9 7 8 1]
                     [6 8 2 5 7 1 4 9 3]
                     [1 9 7 8 3 4 5 6 2]
                     [8 2 6 1 9 5 3 4 7]
                     [3 7 4 6 8 2 9 1 5]
                     [9 5 1 7 4 3 6 2 8]
                     [5 1 9 3 2 6 8 7 4]
                     [2 4 8 9 5 7 1 3 6]
                     [7 6 3 4 1 8 2 5 9]])))))
  )