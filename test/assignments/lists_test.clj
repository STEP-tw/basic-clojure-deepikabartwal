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
  )