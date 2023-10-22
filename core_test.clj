(ns hw1.core-test
  (:require [clojure.test :refer :all]
            [hw1.core :refer :all]))
(comment
;;; Simple functions

  (deftest times3-tests
    (is (= 9 (times3 3)))
    (is (= 12 (times3 4))))

  (deftest times-3-or-4-tests
    (is (= 9 (times-3-or-4 3)))
    (is (= 16 (times-3-or-4 4)))
    (is (= 15 (times-3-or-4 5)))
    (is (= 24 (times-3-or-4 6))))

  (deftest poly1-tests
    (is (= -17 (poly 0)))
    (is (= -19 (poly 1)))
    (is (= -9 (poly -1)))
    (is (= -21 (poly 2)))
    (is (= 11 (poly -2))))

  (deftest perform-tests
    (is (= 3 (perform 'add 1 2)))
    (is (= 9 (perform 'add -9 18)))
    (is (= -1 (perform 'subtract 1 2)))
    (is (= 3 (perform 'subtract 9 6)))
    (is (= 10 (perform 'multiply 5 2)))
    (is (= 1/5 (perform 'multiply 2/5 1/2)))
    (is (= 1/3 (perform 'divide 1 3)))
    (is (= 19/5 (perform 'divide 19 5)))
    (is (= 6 (perform 'divide 18 3))))

;;; Lists and vectors

  (deftest third-tests
    (is (= 'c (third '(a b c 1 2 3))))
    (is (= 'monkey (third '(banana tree monkey happy))))
    (is (= 3 (third '(1 2 3)))))

  (deftest tenth-tests
    (is (= '10 (tenth [1 2 3 4 5 6 7 8 9 10 11 12])))
    (is (=
         'elephant
         (tenth
          '[zebra
            monkey
            bobcat
            lion
            bear
            gopher
            seahorse
            mongoose
            wolf
            elephant]))))

  (deftest sum3-tests
    (is (= 6 (sum3 '(1 2 3))))
    (is (= 5 (sum3 '(0 2 3 4 5 6 7))))
    (is (= -1 (sum3 '(-5 2 2 0 -1 18)))))

  (deftest firstodd?-tests
    (is (= false (firstodd? [2 4 7])))
    (is (= true (firstodd? [1 2 3])))
    (is (= false (firstodd? [18])))
    (is (= true (firstodd? [9]))))

  (deftest list-info-str-tests
    (is (= "nil" (list-info-str nil)))
    (is (= "empty" (list-info-str ())))
    (is (= "1 element" (list-info-str '(a))))
    (is (= "1 element" (list-info-str (list 99))))
    (is (= "2 elements" (list-info-str '(a b))))
    (is (= "5 elements" (list-info-str '(one two three four five)))))

;;; Maps

  (deftest make-account-tests
    (is (= {:owner "Fred", :id 10, :balance 0}
           (make-account 10 "Fred")))
    (is (= {:owner "Barney Rubble", :id 99, :balance 0}
           (make-account 99 "Barney Rubble"))))

  (deftest deposit-tests
    (is (= 100
           (:balance (deposit {:balance 25} 75))))
    (is (= 1019
           (:balance (deposit {:balance 19} 1000))))
    (is (= "Fred"
           (:owner (deposit {:balance 99 :owner "Fred"} 500))))
    (is (= 8
           (:balance (deposit {:balance 8} -5))))
    (is (= -143
           (:balance (deposit {:balance -143} -2)))))

  (deftest account-str-tests
    (is (= "Account 12983 owned by Fred with balance $1000"
           (account-str {:owner "Fred", :id 12983, :balance 1000})))
    (is (= "Account 13 owned by Barney Rubble with balance $50"
           (account-str {:owner "Barney Rubble", :id 13, :balance 50})))
    (is (= "Account 99 owned by Dino with balance $5"
           (account-str {:id 99, :owner "Dino", :balance 5, :who-cares 13})))))