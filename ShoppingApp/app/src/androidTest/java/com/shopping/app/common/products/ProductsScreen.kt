package com.shopping.app.common.products

import com.shopping.app.R
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView

object ProductsScreen : Screen<ProductsScreen>() {

    private val title = KTextView {
        withText("Shopping App")
        isDescendantOfA { withId(R.id.toolbarMain) }
    }

    fun checkScreenTitle() {
        title.isDisplayed()
    }
}