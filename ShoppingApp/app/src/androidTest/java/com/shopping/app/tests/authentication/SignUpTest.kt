package com.shopping.app.tests.authentication

import androidx.test.filters.LargeTest
import com.shopping.app.common.AndroidDialog
import com.shopping.app.common.authentication.AuthenticationScreen
import com.shopping.app.data.authentication.AuthenticationTab
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
                flakySafely(timeoutMs = 5000, intervalMs = 1000, ) {
                    enrollUser("", "", "", "")
                }
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
}