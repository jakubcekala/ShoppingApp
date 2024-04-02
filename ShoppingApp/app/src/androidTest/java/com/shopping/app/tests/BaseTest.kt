package com.shopping.app.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.google.firebase.auth.FirebaseAuth
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.shopping.app.data.preference.UserPref
import com.shopping.app.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before

open class BaseTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    val context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        val userPref = UserPref(context)
        CoroutineScope(Dispatchers.Main).launch {
            FirebaseAuth.getInstance().signOut()
            userPref.clearAllPreference()
        }
    }
}