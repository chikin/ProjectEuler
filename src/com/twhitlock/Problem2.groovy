package com.twhitlock

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

 By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * Created by twhitlock on 2/26/14.
 */


def fibN = 2
def fibNMinus1 = 1
def limit = 4000000
def sum = 0

def isEven(number) {
    return number % 2 == 0
}

def fibonacci(n, nMinusOne) {
    return n + nMinusOne
}

while(fibN < limit) {
    if(isEven(fibN) ) {
        sum = sum + fibN
    }

    def temp = fibN
    fibN = fibonacci(fibN, fibNMinus1)
    fibNMinus1 = temp
}

println sum