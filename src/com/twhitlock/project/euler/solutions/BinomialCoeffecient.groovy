package com.twhitlock.project.euler.solutions

/**
 * Created by twhitlock on 4/8/14.
 * This is using combinatorics to solve problem 15, Lattice Paths.
 *
 */

int gridSize = 20
long paths = 1

for(int i = 0; i < gridSize; i++) {
    paths *= (2 * gridSize) - i
    paths /= i + 1
}

println "There are ${paths} through a ${gridSize} grid"
