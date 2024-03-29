package com.shopping.app.common

import androidx.annotation.StringRes
import com.shopping.app.R
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object AndroidDialog : Screen<AndroidDialog>() {

    private val message = KTextView { withId(android.R.id.message) }
    private val button1 = KButton {withId(android.R.id.button1) }
    private val button2 = KButton {withId(android.R.id.button2) }
    private val button3 = KButton {withId(android.R.id.button3) }

    private fun verifyDialogMessage(@StringRes title: Int) {
        message {
            isDisplayed()
            hasText(title)
        }
    }

    private fun verifyDialogMessage(title: String) {
        message {
            isDisplayed()
            hasText(title)
        }
    }

    private fun clickCloseButton() {
        button1.click()
    }

    fun verifyEmptyFieldError() {
        verifyDialogMessage(R.string.fields_cannot_empty)
        clickCloseButton()
    }

    fun verifyInvalidEmailError() {
        verifyDialogMessage(R.string.enter_valid_email)
        clickCloseButton()
    }

    fun verifyShortPasswordError() {
        verifyDialogMessage(R.string.password_greater_than_5)
        clickCloseButton()
    }

    fun verifyInvalidCredentialsError() {
        verifyDialogMessage("The password is invalid or the user does not have a password.")
        clickCloseButton()
    }
}