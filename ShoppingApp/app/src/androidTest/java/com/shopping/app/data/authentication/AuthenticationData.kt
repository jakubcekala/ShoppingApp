package com.shopping.app.data.authentication

object SignInData {
    const val email = "test@gmail.com"
    const val password = "123456"
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