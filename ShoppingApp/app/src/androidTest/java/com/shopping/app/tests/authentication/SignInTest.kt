package com.shopping.app.tests.authentication

import androidx.test.filters.LargeTest
import com.shopping.app.common.AndroidDialog
import com.shopping.app.common.authentication.AuthenticationScreen
import com.shopping.app.common.products.ProductsScreen
import com.shopping.app.data.authentication.AuthenticationData_IncorrectEmail
import com.shopping.app.data.authentication.AuthenticationData_TooShortPassword
import com.shopping.app.data.authentication.AuthenticationTab
import com.shopping.app.data.authentication.SignInData_Correct
import com.shopping.app.data.authentication.SignInData_Incorrect
import com.shopping.app.tests.BaseTest
import org.junit.Test

@LargeTest
class SignInTest : BaseTest() {

    @Test
    fun verifyAuthenticationScreenContent() = run {
        step("Verify authentication screen content - Sign in tab") {
            AuthenticationScreen {
                verifyCommonScreenElements()
                verifySignInScreenElements()
            }
        }
        step("Verify authentication screen content - Sign up tab") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                verifySingUpScreenElements()
            }
        }
    }

    @Test
    fun verifyEmptyFieldError() = run {
        step("Verify error message when there is no email and password entered") {
            AuthenticationScreen {
                authenticate("", "")
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when there is only email: ${SignInData_Correct.email} and no password entered") {
            AuthenticationScreen {
                authenticate(SignInData_Correct.email, "")
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when there is no email and only password: ${SignInData_Correct.password} entered") {
            AuthenticationScreen {
                authenticate("", SignInData_Correct.password)
            }
            AndroidDialog.verifyEmptyFieldError()
        }
    }

    @Test
    fun verifyInvalidEmailError() = run {
        step("Verify error message when there is email with incorrect format: ${AuthenticationData_IncorrectEmail.email}") {
            AuthenticationScreen {
                authenticate(AuthenticationData_IncorrectEmail.email, AuthenticationData_IncorrectEmail.password)
            }
            AndroidDialog.verifyInvalidEmailError()
        }
    }

    @Test
    fun verifyTooShortPasswordError() = run {
        step("Verify error message when there is too short password: ${AuthenticationData_TooShortPassword.password}") {
            AuthenticationScreen {
                authenticate(AuthenticationData_TooShortPassword.email, AuthenticationData_TooShortPassword.password)
            }
            AndroidDialog.verifyShortPasswordError()
        }
    }

    @Test
    fun verifyIncorrectCredentialsError() = run {
        step("Verify error message when there are incorrect credentials, email: ${SignInData_Incorrect.email} password: ${SignInData_Incorrect.password}"){
            AuthenticationScreen {
                authenticate(SignInData_Incorrect.email, SignInData_Incorrect.password)
            }
            AndroidDialog.verifyInvalidCredentialsError()
        }
    }

    @Test
    fun successfulSignIn() = run {
        step("User successfully sign in using email: ${SignInData_Correct.email} and password: ${SignInData_Correct.password}") {
            AuthenticationScreen {
                authenticate(SignInData_Correct.email, SignInData_Correct.password)
            }
        }
        step("Check if products screen is visible") {
            ProductsScreen.checkScreenTitle()
        }
    }
}