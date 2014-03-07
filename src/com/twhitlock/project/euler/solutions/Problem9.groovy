package com.twhitlock.project.euler.solutions

/**
 * Created by twhitlock on 3/4/14.
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

 a2 + b2 = c2
 For example, 32 + 42 = 9 + 16 = 25 = 52.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.
 */

for(int a = 0; a < 1000 ; a++) {
    def aSquared = a * a;
    for(int b = 0; b < 1000; b++) {
        def bSquared = b * b;
        def c = Math.sqrt(aSquared +bSquared )
        if(a + b + c == 1000) {
            println "a: ${a} b: ${b} c: ${c}"
            println "a*b*c ${a*b*c}"
            break
        }
    }
}

