package com.shopping.app.common

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object AndroidDialog : Screen<AndroidDialog>() {

    private val message = KTextView { withId(android.R.id.message) }
    private val button1 = KButton {withId(android.R.id.button1) }
    private val button2 = KButton {withId(android.R.id.button2) }
    private val button3 = KButton {withId(android.R.id.button3) }

    fun verifyDialogMessage(title: String) {
        message {
            isDisplayed()
            hasText(title)
        }
    }

    fun clickCloseButton() {
        button1.click()
    }
}