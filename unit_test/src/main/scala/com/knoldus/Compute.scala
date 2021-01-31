
package com.knoldus



trait Calculation{

  def divide(divident: Int,divisor: Int): Double
  def fibonacci(upto:Int):List[Int]
}

class Compute extends Calculation
{

  def divide(divident: Int,divisor: Int) :Double = {

    if(divisor == 0){

      throw new ArithmeticException("Not divisible by zero")
    }
    divident/divisor
  }

  def fibonacci(upto:Int):List[Int]={
    if(upto<0)
      throw new IllegalArgumentException("Negative number not allowed")
    var FibonacciSeries = List.empty[Int]
    var firstTerm = 0
    var secondTerm = 1
    var nextTerm=0

    while(nextTerm<=upto){

      FibonacciSeries=FibonacciSeries:+nextTerm
      firstTerm=secondTerm
      secondTerm=nextTerm
      nextTerm=firstTerm+secondTerm
    }
    FibonacciSeries
  }
}