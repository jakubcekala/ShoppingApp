package com.shopping.app.tests.authentication

import androidx.test.filters.LargeTest
import com.shopping.app.common.authentication.AuthenticationScreen
import com.shopping.app.data.authentication.AuthenticationTab
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
}