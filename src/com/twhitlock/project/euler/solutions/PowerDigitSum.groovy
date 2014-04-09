package com.twhitlock.project.euler.solutions

/**
 * Created by twhitlock on 4/8/14.
 *

 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 What is the sum of the digits of the number 2^1000?

 */
def number = (2**1000).toString()
println "2**1000 = ${number}"
def sum = 0
for(def i = 0; i < number.length(); i++) {
    sum = sum + Integer.parseInt(number[i])
}
println "sum = ${sum}"