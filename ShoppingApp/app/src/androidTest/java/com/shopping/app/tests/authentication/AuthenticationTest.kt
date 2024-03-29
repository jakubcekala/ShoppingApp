package com.shopping.app.tests.authentication

import androidx.test.filters.LargeTest
import com.shopping.app.common.AndroidDialog
import com.shopping.app.common.authentication.AuthenticationScreen
import com.shopping.app.data.authentication.AuthenticationTab
import com.shopping.app.data.authentication.SignInData_Correct
import com.shopping.app.data.authentication.SignInData_Incorrect
import com.shopping.app.data.authentication.SignInData_IncorrectEmail
import com.shopping.app.data.authentication.SignInData_TooShortPassword
import com.shopping.app.tests.BaseTest
import org.junit.Test

@LargeTest
class AuthenticationTest : BaseTest() {

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
            AndroidDialog {
                verifyDialogMessage("Fields cannot be empty!")
                clickCloseButton()
            }
        }
        step("Verify error message when there is only email: ${SignInData_Correct.email} and no password entered") {
            AuthenticationScreen {
                authenticate(SignInData_Correct.email, "")
            }
            AndroidDialog {
                verifyDialogMessage("Fields cannot be empty!")
                clickCloseButton()
            }
        }
        step("Verify error message when there is no email and only password: ${SignInData_Correct.password} entered") {
            AuthenticationScreen {
                authenticate("", SignInData_Correct.password)
            }
            AndroidDialog {
                verifyDialogMessage("Fields cannot be empty!")
                clickCloseButton()
            }
        }
    }

    @Test
    fun verifyInvalidEmailError() = run {
        step("Verify error message when there is email with incorrect format: ${SignInData_IncorrectEmail.email}") {
            AuthenticationScreen {
                authenticate(SignInData_IncorrectEmail.email, SignInData_IncorrectEmail.password)
            }
            AndroidDialog {
                verifyDialogMessage("Please enter a valid email address!")
                clickCloseButton()
            }
        }
    }

    @Test
    fun verifyTooShortPasswordError() = run {
        step("Verify error message when there is too short password: ${SignInData_TooShortPassword.password}") {
            AuthenticationScreen {
                authenticate(SignInData_TooShortPassword.email, SignInData_TooShortPassword.password)
            }
            AndroidDialog {
                verifyDialogMessage("Password must be greater than 5 characters!")
                clickCloseButton()
            }
        }
    }

    @Test
    fun verifyIncorrectCredentialsError() = run {
        step("Verify error message when there are incorrect credentials, email: ${SignInData_Incorrect.email} password: ${SignInData_Incorrect.password}"){
            AuthenticationScreen {
                authenticate(SignInData_Incorrect.email, SignInData_Incorrect.password)
            }
            AndroidDialog {
                verifyDialogMessage("The password is invalid or the user does not have a password.")
                clickCloseButton()
            }
        }
    }
}