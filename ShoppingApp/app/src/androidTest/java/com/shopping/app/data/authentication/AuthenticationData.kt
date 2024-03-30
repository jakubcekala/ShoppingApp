package com.shopping.app.data.authentication

object SignInData_Correct {
    const val email = "test@gmail.com"
    const val password = "123456"
}

object SignInData_Incorrect {
    const val email = "test@gmail.com"
    const val password = "123465"
}

object AuthenticationData_IncorrectEmail {
    const val email = "test"
    const val password = "123456"
}

object AuthenticationData_TooShortPassword {
    const val username = "test"
    const val email = "test@gmail.com"
    const val password = "1234"
}

object SignUpData {
    var username = "test${System.currentTimeMillis()}"
    var email = "test${System.currentTimeMillis()}@gmail.com"
    const val password = "123456"
}

enum class AuthenticationTab {
    SIGN_IN,
    SIGN_UP
}