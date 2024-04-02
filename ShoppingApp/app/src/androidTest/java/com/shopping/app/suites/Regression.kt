package com.shopping.app.suites

import com.shopping.app.tests.authentication.SignInTest
import com.shopping.app.tests.authentication.SignUpTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SignInTest::class,
    SignUpTest::class
)
class Regression