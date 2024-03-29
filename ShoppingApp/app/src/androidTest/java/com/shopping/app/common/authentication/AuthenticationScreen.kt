package com.shopping.app.common.authentication

import com.shopping.app.R
import com.shopping.app.data.authentication.AuthenticationTab
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object AuthenticationScreen : Screen<AuthenticationScreen>() {
    private val icon = KImageView { withId(R.id.ivLogo) }
    private val title = KTextView { withId(R.id.tvTitle) }
    private val tabLayout = KTabLayout { withId(R.id.tabLayout) }
    private val emailTextField = KEditText { withId(R.id.etEmail) }
    private val passwordTextField = KEditText { withId(R.id.etPassword) }
    private val signInBtn = KButton { withId(R.id.btnSignIn) }
    private val usernameTextField = KEditText { withId(R.id.etUsername) }
    private val passwordAgainTextField = KEditText { withId(R.id.etPasswordAgain) }
    private val signUpBtn = KButton { withId(R.id.btnSignUp) }
    private val isSignInFormVisible = true

    fun verifyCommonScreenElements() {
        icon.isDisplayed()
        title {
            isVisible()
            hasText("Welcome to Shopping App")
        }
        tabLayout {
            hasDescendant {
                isDisplayed()
                withText("SIGN IN")
            }
            hasDescendant {
                isDisplayed()
                withText("SIGN UP")
            }
        }
        emailTextField {
            isDisplayed()
            hasHint("Email")
        }
        passwordTextField {
            isDisplayed()
            hasHint("Password")
        }
    }

    fun verifySignInScreenElements() {
        signInBtn {
            isDisplayed()
            hasText("SIGN IN")
        }
    }

    fun verifySingUpScreenElements() {
        usernameTextField {
            isDisplayed()
            hasHint("Username")
        }
        passwordAgainTextField {
            isDisplayed()
            hasHint("Password Again")
        }
        signUpBtn {
            isDisplayed()
            hasText("SIGN UP")
        }
    }

    fun authenticate(email: String, password: String) {
        emailTextField.replaceText(email)
        passwordTextField.replaceText(password)
        signInBtn.click()
    }

    fun enrollUser(username: String, email: String, password: String, passwordAgain: String = password) {
        usernameTextField.replaceText(username)
        emailTextField.replaceText(email)
        passwordTextField.replaceText(password)
        passwordAgainTextField.replaceText(passwordAgain)
        signUpBtn.click()
    }

    fun changeTab(tab: AuthenticationTab) {
        when(tab) {
            AuthenticationTab.SIGN_IN -> {
                tabLayout.selectTab(0)
                signInBtn.isCompletelyDisplayed()
            }
            AuthenticationTab.SIGN_UP -> {
                tabLayout.selectTab(1)
                signUpBtn.isCompletelyDisplayed()
            }
        }
    }
}