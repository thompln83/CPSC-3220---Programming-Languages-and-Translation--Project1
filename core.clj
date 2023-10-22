(ns hw1.core
  (:gen-class))

;; Lauren Thompson CPSC3220 October 2023

;; Simple Functions 1
;;
;; times3 takes a single numeric argument; 
;; returns value of this argument multiplied by three.

(defn times3
  [x]
  (* x 3))

(comment
  (times3 1)
  ;; 3 
  (times3 3)
  ;; 9
  (times3 4))
  ;; 12

;; Simple Functions 2
;;
;; times-3-or-4 takes a single integer argument 
;; if the argument is odd, returns 3 times the argument 
;; otherwise 4 times the argument.

(defn times-3-or-4
  [x]
  (cond
    (odd? x) (* x 3)
    (even? x) (* x 4)))

(comment
  (times-3-or-4 3)
  ;; 9
  (times-3-or-4 4)
  ;; 12
  (times-3-or-4 5)
  ;; 15
  (times-3-or-4 6))
  ;; 24


;; Simple Functions 3
;;
;; polynomial function -x^3 + 3x^2 - 4x - 17
;; Break down to 3 pieces- 
;;    Piece 1: x^3; 
;;    Piece 2: 3x^2; 
;;    Piece 3: 4x - 17; watch signs
;;
;; Piece 1 (- (+ (* -1 (Math/pow x 3))
;; Piece 2 (* 3 (Math/pow x 2))
;; Piece 3 (* -4 x)) 17))

(defn poly
  [x]
  (- (+ (* -1 (Math/pow x 3)) (* 3 (Math/pow x 2)) (* -4 x)) 17))

(comment
  (poly 0)
  ;; -17
  (poly 1)
  ;; -19
  (poly -1)
  ;; -9
  (poly 2)
  ;; -21
  (poly 3)
  ;; -29
  (poly 4))
  ;; -49

;; Simple Functions 4
;;
;; Three arguments: operation, value1, value2
;; Operation can be: add, subtract, multiply or divide
;; build cases for each operation 

;; CHECK LINE 64 () ISSUE
(defn perform
  [operation value1 value2]

  (case operation
    add (+ value1 value2)        ;; +
    subtract (- value1 value2)   ;; -
    divide (/ value1 value2)     ;; /
    multiply (* value1 value2))) ;; *

;; DELETE?
;;(defn perform 
;;  [operation value1 value2]
;;  (cond
;;      (= 'add \+) (+ value1 value2)
;;      (= 'subtract \-) (- value1 value2)
;;      (= 'multiply \*) (* value1 value2)
;;      (= 'divide /) (/ value1 value2)
;; ?

(comment
  (perform 'add 1 2)
  ;; 3
  (perform 'add -9 18)
  ;; 9
  (perform 'subtract 1 2)
  ;; -1
  (perform 'subtract 9 6)
  ;; 3
  (perform 'multiply 5 2)
  ;; 10
  (perform 'multiply 2/5 1/2)
  ;; 1/5
  (perform 'divide 1 3)
  ;; 1/3  
  (perform 'divide 9 5)
  ;; 9/5
  (perform 'divide 18 3))
  ;; 6

;; Lists & Vecors 5
;;
;; third that takes a single list argument (containing at least 3 elements)
;; and returns the third element of that list.

(defn third
  [lst]                          ;; lst
  (if (>= (count lst) 3)         ;; must contain 3 or more
    (nth lst 2)))                ;; use nth with 2 

(comment
  (third '(a b c 1 2 3))
  ;; c
  (third '(banana tree monkey happy)))
  ;; monkey

;; DELETE?
;;(defn third
  ;;["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"])
;;(nth third 3)
;;(defn third)
;(nth '(:a :b :c) 0)
 ; => :a
;; ?

;; Lists & Vecors 6
;;
;; function tenth that takes a single vector argument 
;; (containing at least ten elements) and returns 
;; the tenth element of that vector. 

(defn tenth
  [vec]                        ;; vector
  (if (>= (count vec) 10)      ;; must contain 10 or more)
    (nth vec 9)))              ;; uses nth with vector at 9

(comment
  (tenth [1 2 3 4 5 6 7 8 9 10 11 12]))
  ;; 10
  ;;(tenth [zebra monkey bobcat lion bear gopher seahorse mongoose wolf elephant]))
  ;; elephant

;; DELETE ?
;;(defn tenth
  ;;["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"])
;;(nth tenth 10)
;; ?

;; Lists & Vecors 7
;;
;; function sum3 that takes a single list argument 
;; (containing at least 3 numeric elements) and 
;; returns the sum of the first three elements of that list.

(defn sum3
  [lst]                              ;; lst 
  (if (>= (count lst) 3)             ;; must have 3 or more
    (reduce + (take 3 lst))))        ;; sum 

(comment
  (sum3 '(1 2 3))
  ;; 6
  (sum3 '(0 2 3 4 5 6 7))
  ;; 5 
  (sum3 '(-5 2 2 0 -1 18)))
  ;; -1


;; Lists & Vecors 8
;;
;; function firstodd? that takes a single vector argument 
;; (containing at least 1 numeric element) and returns true if the 
;; first element of the vector is odd or false otherwise.

;; CHECK () for this function
(defn firstodd?
  [vec]                            ;; vector
  (if (>= (count vec) 1)          ;; must have 1 or more 
    (odd? (first vec))))            ;; checks if first element of vector 

(comment
  (firstodd? [2 4 7])
  ;; false
  (firstodd? [1 2 3])
  ;; true 
  (firstodd? [18])
  ;; false
  (firstodd? [9]))

;; Lists & Vecors 9
;;
;; function list-info-str that takes a single argument that will 
;; either be a list or nil and returns a string as follows:
;; • If the argument is nil, return the string "nil";
;; • if the argument is a empty list, return the string "empty";
;; • if the argument has exactly one element, return the string "1 element";
;; • otherwise return the string "<n> elements" where <n> is 
;;   replaced by the number of elements in the list.

(defn list-info-str
  [lst]
  (if (nil? lst)                                    ;; nil argument
    "nil"                                           ;; return nil 
    (if (empty? lst)                                ;; empty lst argument
      "empty"                                       ;; return empty
      (let [num-elements (count lst)]
        (if (= num-elements 1)                 ;; exactly 1 element argument                          
          "1 element"                          ;; return 1 element
          (str num-elements " elements"))))))   ;; return "<n> elements" 

(comment
  (list-info-str nil)
  ;; nil 
  (list-info-str ())
  ;; empty
  (list-info-str '(a))
  ;; 1 element
  (list-info-str (list 99))
  ;; 1 element
  (list-info-str '(a b))
  ;; 2 elements 
  (list-info-str '(one two three four five)))


;; Maps 10
;; 
;; function (make-account id owner) that takes integer (id) 
;; and string (owner) as arguments
;; function must return a map with key :owner 
;; set to the owner argument, key :id set to the id argument and 
;; key :balance set to 0 (zero)

(defn make-account
  [id owner]                             ;; id (int) owner (string) argument 
  {:owner owner, :id id, :balance 0})    ;; map with key :owner & :id

(comment
  (make-account 10 "Fred")
;; {:owner "Fred", :id 10, :balance 0} 
  (make-account 99 "Barney Rubble"))
;; {owner "Barney Rubble", :id 99, :balance 0}

;; Maps 11
;;
;; function (deposit account amount) that accepts a map, account, 
;; and a number, amount, as arguments. 
;; The map account will map the keyword :balance to a number. 
;; Your function deposit must return a new map with the :balance value increased by amount, 
;; if amount is positive or unchanged (if amount is not positive)

(defn deposit
  [account amount]                                                     ;; map (account) & number (amount)
  (if (pos? amount)                                                    ;; check for positive amount
    (assoc account :balance (+ (:balance account) amount)) account))   ;; map :balance value increased by amount (if + or no change)

(comment
  (:balance (deposit {:balance 25} 75))
        ;; 100
  (:balance (deposit {:balance 19} 1000))
        ;; 1019
  (:owner (deposit {:balance 99 :owner "Fred"} 500))
        ;; "Fred"
  (:balance (deposit {:balance 8} -5))
        ;; 8
  (:balance (deposit {:balance -143} -2)))
        ;; -143

;; Maps 12
;;
;; (account-str account) accepts a map with (at least) the keys :owner, 
;; :id and :balance and returns a string formatted as shown in the examples below.
;; > (account-str {:owner "Fred", :id 12983, :balance 1000})
;;   Account 12983 owned by Fred with balance $1000

(defn account-str
  [account]                                           ;; account
  (let [owner (:owner account)                        ;; owner from map
        id (:id account)                              ;; id from map
        balance (:balance account)]                   ;; balance from

    (str "Account " id " owned by " owner " with balance $" balance)))

(comment
  (account-str {:owner "Fred ", :id 12983 , :balance 1000}))
          ;; "Account 12983 owned by Fred with balance $1000"