package com.twhitlock.project.euler.solutions

/**
 * Created by twhitlock on 3/11/14.
 * The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.
 */


long nextFromEven(long n) {
    return n / 2
}

long nextFromOdd(long n) {
    return (3*n) + 1
}

def collatzSequence(long startingNumber) {
    def sequence = []
    sequence.add(startingNumber)
    if(startingNumber % 2 == 0) {
        sequence.add(collatzSequence(nextFromEven(startingNumber)))
    } else {
        if(startingNumber != 1 ) {
            sequence.add(collatzSequence(nextFromOdd(startingNumber)))
        }
    }
    return sequence.flatten()
}

println collatzSequence(13).size()

def longestChainStartingNumber = 1;
def maxLength = 1;

for(int i = 1; i < 1000000; i++) {
    def length = collatzSequence(i).size()
    if(length > maxLength) {
        longestChainStartingNumber = i
        maxLength = length
        println "Starting number with the longest chain ${longestChainStartingNumber}"
        println "chain length ${maxLength}"
    }
}

println "Starting number with the longest chain ${longestChainStartingNumber}"
println "chain length ${maxLength}"