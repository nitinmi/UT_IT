package com.knoldus.request

import com.knoldus.models.{Company, User}
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImplTest extends AnyFlatSpec {

  val mockedUserValidate = mock[UserValidator]
  val karanUser: User = User("Karan","Sharma","knoldus","karan@knoldus.com")
  val nitinUser: User = User("nitin","mittal","knoldus","priya.mittal@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {

    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(nitinUser)) thenReturn (true)
    val result = userImpl.createUser(nitinUser)
    assert(!result.isEmpty)
  }

  "User" should "be not valid" in {

    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(karanUser)) thenReturn (false)
    val result = userImpl.createUser(karanUser)
    assert(result.isEmpty)
  }
}
