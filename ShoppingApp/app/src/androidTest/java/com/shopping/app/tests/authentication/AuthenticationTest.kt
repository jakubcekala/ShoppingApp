package com.shopping.app.tests.authentication

import androidx.test.filters.LargeTest
import com.shopping.app.common.AndroidDialog
import com.shopping.app.common.authentication.AuthenticationScreen
import com.shopping.app.data.authentication.AuthenticationTab
import com.shopping.app.data.authentication.SignInData
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
        step("Verify error message when there is only email: ${SignInData.email} and no password entered") {
            AuthenticationScreen {
                authenticate(SignInData.email, "")
            }
            AndroidDialog {
                verifyDialogMessage("Fields cannot be empty!")
                clickCloseButton()
            }
        }
        step("Verify error message when there is no email and only password: ${SignInData.password} entered") {
            AuthenticationScreen {
                authenticate("", SignInData.password)
            }
            AndroidDialog {
                verifyDialogMessage("Fields cannot be empty!")
                clickCloseButton()
            }
        }
    }
}