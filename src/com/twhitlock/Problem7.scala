/**
 *
 * Created by twhitlock on 2/28/14.
 */
import scala.collection.mutable
def diff(t2: (Int, Int)) = -t2._2
val x = new mutable.PriorityQueue[(Int, Int)]()(Ordering.by(diff))
def nextPrimeAfter(prime: Int, x: mutable.PriorityQueue[(Int, Int)]) {
  if(!x.isEmpty && x.min._2 > prime) {
    println("enqueued:" + prime)
    x.enqueue(prime -> prime * prime)
  } else {
    if(!x.isEmpty) {
      while(prime <= x.min._2) {
        println("Prime: " +prime)
        val old = x.dequeue()
        println("old:" + old)
        val newValue = prime + old._1
        println("newValue:" +newValue )
        x.enqueue(old._1 -> newValue)
        println("x:" +x)
      }
    }
    //    x.enqueue(prime -> prime * prime)
  }
}
nextPrimeAfter(2, x)
nextPrimeAfter(3, x)
nextPrimeAfter(4, x)
nextPrimeAfter(5, x)
x
x.min
/*
Algorithm that I'm planning:
  Take an input p, and a priority queue
  if p is less than the minimum number in the priority queue, it's prime
    Add it to the priority queue with the value of p * p
  else
    p == the minimum number in the priority queue
    while p == the min.  Dequeue the tuple and enqueue it again with the value of p + oldPrime
 */
//if(testPrime < x.min._2) {
//  enqueueNewPrime(testPrime, x)
//} else {
//  testPrime = testPrime + 1
//}
//
//x
//testPrime