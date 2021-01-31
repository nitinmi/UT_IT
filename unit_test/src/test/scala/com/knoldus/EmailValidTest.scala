package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidTest extends AnyFlatSpec{

  val emailValidator = new EmailValid

  "email" should "have alphanumeric username in lowercase and uppercase " in {

    val result: Boolean = emailValidator.isValidEmail("nitin@knoldus.com")
    assert(result == true)
  }

  "email" should "valid when with starting numbers" in {

    val result: Boolean = emailValidator.isValidEmail("1nitim@knoldus.com")
    assert(result == true)
  }

  "email" should "invalid with missing @" in {

    val result: Boolean = emailValidator.isValidEmail("nitinknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {

    val result: Boolean = emailValidator.isValidEmail("*/nitinknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with space in between" in {

    val result: Boolean = emailValidator.isValidEmail("nitin @knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with missing top level domain" in {

    val result: Boolean = emailValidator.isValidEmail("nitin@knoldus")
    assert(result == false)
  }

  "email" should "invalid with missing domain main" in {

    val result: Boolean = emailValidator.isValidEmail("nitin@.com")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {

    val result: Boolean = emailValidator.isValidEmail("nitin@knoldus.xyz")
    assert(result == false)
  }

  "email" should "invalid with more than one top level domain" in {

    val result: Boolean = emailValidator.isValidEmail("nitin@knoldus.com.net")
    assert(result == false)
  }

  "email" should "invalid with double dots after domain name" in {

    val result: Boolean = emailValidator.isValidEmail("nitin@knoldus..com")
    assert(result == false)
  }
}