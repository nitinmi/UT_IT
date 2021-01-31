package com.knoldus

class EmailValid {                    //return if email is valid or not

  def isValidEmail(emailid: String) :Boolean={

    val regex= """^([_|a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
     emailid.matches(regex)
  }

  def main(args:Array[String]) ={

    val ch= isValidEmail("nitin@gmail.com")
    println(ch)
  }
}
