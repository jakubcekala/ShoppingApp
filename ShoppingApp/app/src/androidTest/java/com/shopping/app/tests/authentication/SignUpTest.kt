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
import com.shopping.app.data.authentication.SignUpData
import com.shopping.app.tests.BaseTest
import org.junit.Test

@LargeTest
class SignUpTest : BaseTest() {

    @Test
    fun verifyEmptyFieldError() = run {
        step("Verify error message when there is no data entered") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser("", "", "", "")
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when the username field is empty") {
            AuthenticationScreen {
                enrollUser("", SignUpData.email, SignUpData.password, SignUpData.password)
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when the email field is empty") {
            AuthenticationScreen {
                enrollUser(SignUpData.username, "", SignUpData.password, SignUpData.password)
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when the password field is empty") {
            AuthenticationScreen {
                enrollUser(SignUpData.username, SignUpData.email, "", SignUpData.password)
            }
            AndroidDialog.verifyEmptyFieldError()
        }
        step("Verify error message when the password field is empty") {
            AuthenticationScreen {
                enrollUser(SignUpData.username, SignUpData.email, SignUpData.password, "")
            }
            AndroidDialog.verifyEmptyFieldError()
        }
    }

    @Test
    fun verifyInvalidEmailError() = run {
        step("Verify error message when there is email with incorrect format: ${AuthenticationData_IncorrectEmail.email}") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser(SignUpData.username, AuthenticationData_IncorrectEmail.email, SignUpData.password)
            }
            AndroidDialog.verifyInvalidEmailError()
        }
    }

    @Test
    fun verifyTooShortPasswordError() = run {
        step("Verify error message when there is too short password: ${AuthenticationData_TooShortPassword.password}") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser(SignUpData.username, SignUpData.email, AuthenticationData_TooShortPassword.password)
            }
            AndroidDialog.verifyShortPasswordError()
        }
    }

    @Test
    fun emailAddressAlreadyUsed() = run {
        step("Verify error message when there is already used email entered: ${SignInData_Correct.email}") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser(SignUpData.username, SignInData_Correct.email, SignUpData.password)
            }
            AndroidDialog.verifyEmailAlreadyUsedError()
        }
    }

    @Test
    fun passwordsDoNotMatch() = run {
        step("Verify error message when passwords do not match, password: ${SignUpData.email}, password 2: ${SignInData_Incorrect.password}") {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser(SignUpData.username, SignInData_Correct.email, SignUpData.password, SignInData_Incorrect.password)
            }
            AndroidDialog.verifyPasswordDoNotMatchError()
        }
    }

    @Test
    fun successfulSignUp() = run {
        step(
            "User successfully sign up using username: ${SignUpData.username}, email: ${SignUpData.email}, password: ${SignUpData.password}"
        ) {
            AuthenticationScreen {
                changeTab(AuthenticationTab.SIGN_UP)
                enrollUser(SignUpData.username, SignUpData.email, SignUpData.password)
            }
        }
        step("Check if products screen is visible") {
            ProductsScreen.checkScreenTitle()
        }
    }
}