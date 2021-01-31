package com.knoldus.request

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)

  "User" should "be valid" in {

    val nitinUser: User = User("nitin","mittal","Knoldus","nitin.mittal@knoldus.com")
    val result =  userImpl.createUser(nitinUser)
    assert(!result.isEmpty)
  }

  "User" should "be invalid as it company doesnot exists in DB" in {

    val karanUser: User = User("Karan","Sharma","Google","karan@knoldus.com")
    val result =  userImpl.createUser(karanUser)
    assert(result.isEmpty)
  }

  "Employee" should "be invalid as email id is invalid" in {

    val nitinEmployee: User = User("nitin","mittal","Knoldus","nitin.mittalknoldus.com")
    val result = userImpl.createUser(nitinEmployee)
    assert(result.isEmpty)
  }

  "Employee" should "be invalid as email id is invalid and company does not exists in DB" in {

    val nitinUser: User = User("nitin","mittal","Google","nitin.mittalaknoldus.com")
    val result =  userImpl.createUser(nitinUser)
    assert(result.isEmpty)
  }
}