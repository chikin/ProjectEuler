package com.twhitlock.project.euler.solutions

/**
 * Created by twhitlock on 3/21/14.
 */

/**
 *
 * @return the next point from this one in the x direction
 */
def moveRight(def point) {
    if(point.x < 20) {
        def newX = point.x + 1
        return [x: newX, y: point.y]
    } else {
        return null
    }
}

def moveDown(def point) {
    if(point.y < 20) {
        def newY = point.y + 1
        return [x: point.x, y: newY]
    } else {
        return null
    }
}

/**
 *
 * @param point starting point (x,y)
 * @return up to two new points if we can go right and down
 */
def nextMove(def point) {
    def returnValue = []
    def right = moveRight(point)
    def down = moveDown(point)
    if(right != null) {
        returnValue.add(right)
    }
    if(down != null) {
        returnValue.add(down)
    }

    return returnValue
}

def makeAPath() {
    def startingPoint = [x:0, y:0]
    def allPaths = []
    //Start at 0,0
    def path = []
    path.add(startingPoint)
    boolean morePaths = findNextStep(path, allPaths)
    while(morePaths) {
        def nextPath = allPaths.remove(0)
        morePaths = findNextStep(nextPath, allPaths)
        if(!morePaths) {
            allPaths.add(nextPath)
        }
    }

    println allPaths.size()
}

private boolean findNextStep(ArrayList path, ArrayList allPaths) {
    LinkedHashMap<String, Integer> startingPoint = path[-1]

    def nextMoves = nextMove(startingPoint)
//    println startingPoint
//    println "nextMoves  ${nextMoves}"

    if (nextMoves.isEmpty()) {
        return false
    }
    def path1 = []
    path1.addAll(path)
    path1.add(nextMoves[0])
    allPaths.add(path1)

    if (nextMoves.size() > 1) {
        def path2 = []
        path2.addAll(path)
        path2.add(nextMoves[1])
        allPaths.add(path2)
    }
//    println "allPaths size ${allPaths.size()}"
    return true
}

makeAPath()