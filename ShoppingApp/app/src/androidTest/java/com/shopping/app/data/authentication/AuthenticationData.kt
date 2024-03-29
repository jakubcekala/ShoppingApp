package com.shopping.app.data.authentication

object SignInData_Correct {
    const val email = "test@gmail.com"
    const val password = "123456"
}

object SignInData_Incorrect {
    const val email = "test@gmail.com"
    const val password = "123465"
}

object SignInData_IncorrectEmail {
    const val email = "test"
    const val password = "123456"
}

object SignInData_TooShortPassword {
    const val email = "test@gmail.com"
    const val password = "1234"
}

object SignUpData {
    const val username = ""
    const val email = ""
    const val password = ""
}

enum class AuthenticationTab {
    SIGN_IN,
    SIGN_UP
}