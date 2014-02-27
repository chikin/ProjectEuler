package com.twhitlock

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 * Created by twhitlock on 2/26/14.
 */

boolean isPrime(number) {
    if(number == 1) return true
    if(number % 2 == 0) return false
    def limit = Math.floor(Math.sqrt(number))
    def counter = 2;
    while(counter < limit) {
        if(number % counter == 0) return false
        counter = counter + 1
    }
    return true
}

def factors(double number) {
    def factors = []
    def limit = Math.floor(Math.sqrt(number))
    def counter = 1
    while(counter < limit) {
        if(number % counter == 0) {
          factors.add(counter)
//          factors.add(number / counter)
        }
        counter = counter + 1
    }
    return factors
}

def primeFactors(double number) {
    return factors(number).findAll{ n -> isPrime(n)}
}
//factors(2).each {it -> println it}
//println primeFactors(13195)
println primeFactors(600851475143)