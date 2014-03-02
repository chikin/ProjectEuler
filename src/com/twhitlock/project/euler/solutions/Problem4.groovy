package com.twhitlock.project.euler.solutions

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

 Find the largest palindrome made from the product of two 3-digit numbers.
 * Created by twhitlock on 2/26/14.
 */

boolean isPalindrome(number) {
    def string = "" + number
    def limit = string.size() / 2
    def count = 0
    while(count < limit) {
        if(string[count] != string[string.size() - count - 1]) return false
        count = count + 1
    }
    return true
}

def productOfNumbers(min, max) {
    def numbers = []
    def index = min
    def j = max
    while(index < max) {
        numbers.add(index * max)
        while (j > min) {
            numbers.add(j * index)
            j = j - 1
        }
        index = index + 1
        j = max
    }
    return numbers
}
//println productOfNumbers(100, 999).size()
println productOfNumbers(100, 999).findAll{n -> isPalindrome(n)}.sort().last()
//println productOfNumbers(10, 99)
//println productOfNumbers(10, 99).findAll{n -> isPalindrome(n)}.last()
//println isPalindrome(9009)