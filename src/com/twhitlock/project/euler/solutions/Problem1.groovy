package com.twhitlock.project.euler.solutions
/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

 */
class Problem1 {

  def sum = 0
  def limit = 1000
  def index = 0
  def calculate() {
      while(index < limit) {
        if(index % 3 == 0 || index % 5 == 0) {
            sum = sum + index
        }
        index = index + 1
      }
    println sum
  }

  public static void main(String[] args) {
      def problem1 = new Problem1()
      problem1.calculate()
  }


}