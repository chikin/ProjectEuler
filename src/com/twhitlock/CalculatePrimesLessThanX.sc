/*
 * Created by twhitlock on 12/28/14
 */

import scala.collection.mutable
def nextPrimeAfter(prime: Int, x: mutable.PriorityQueue[(Int, Int)]) {
  if(!x.isEmpty && x.head._2 > prime) {
    x.enqueue(prime -> prime * prime)
  } else {
    if(!x.isEmpty) {
      var testValue = x.head._2
      while(prime == testValue) {
        val old = x.dequeue()
        var nextValue = prime + old._1
        x.enqueue(old._1 -> nextValue)
        testValue = x.head._2
      }
    }
  }
}

def calculatePrimesLessThanN(n: Int) ={
  def orderByNextMultiple(t2: (Int, Int)) = -t2._2
  def orderByPrimeNumber(t2: (Int, Int)) = t2._1
  val x = new mutable.PriorityQueue[(Int, Int)]()(Ordering.by(orderByNextMultiple))
  x.enqueue(2 -> 4)
  var count = 3
  while(count < n) {
    nextPrimeAfter(count, x)
    count = count + 1
  }
  val array: Array[(Int, Int)] = x.toArray
  val sortedArray = array.sortBy(orderByPrimeNumber)
  sortedArray.foreach{ arg =>
    print(arg._1 +",")
  }
  println("")
  //  println(x)
}
calculatePrimesLessThanN(20)


