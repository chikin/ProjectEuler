/*
 * Created by twhitlock on 12/28/14
 */

import scala.collection.mutable
def nextPrimeAfter(prime: BigInt, x: mutable.PriorityQueue[(BigInt, BigInt)]) {
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

def calculatePrimesLessThanN(n: BigInt) = {
  def orderByNextMultiple(t2: (BigInt, BigInt)) = -t2._2
  def orderByPrimeNumber(t2: (BigInt, BigInt)) = t2._1
  val x = new mutable.PriorityQueue[(BigInt, BigInt)]()(Ordering.by(orderByNextMultiple))
  x.enqueue(BigInt.int2bigInt(2) -> BigInt.int2bigInt(4))
  var count = 3
  while(count < n) {
    nextPrimeAfter(count, x)
    count = count + 1
  }
  val array: Array[(BigInt, BigInt)] = x.toArray
  val sortedArray = array.sortBy(orderByPrimeNumber)
  var sum = BigInt.int2bigInt(0)
  sortedArray.foreach{ arg =>
    print(arg._1.toString() +",")
    sum = sum + arg._1
  }
  println("")
  println(sum)
  //  println(x)
}
calculatePrimesLessThanN(2000000)




