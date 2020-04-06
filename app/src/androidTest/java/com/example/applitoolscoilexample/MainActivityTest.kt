package com.example.applitoolscoilexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.applitools.eyes.android.common.BatchInfo
import com.applitools.eyes.android.common.logger.StdoutLogHandler
import com.applitools.eyes.android.components.androidx.AndroidXComponentsProvider
import com.applitools.eyes.android.espresso.Eyes
import com.applitools.eyes.android.espresso.fluent.Target.region
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    companion object {
        val batch = BatchInfo("coil-example")
    }

    @Rule
    @JvmField
    var mainActivity = ActivityTestRule(MainActivity::class.java)

    // Initialize the eyes SDK and set your private API key.
    private val eyes by lazy {
        Eyes().apply {
            componentsProvider = AndroidXComponentsProvider()
            apiKey = "your api key here"
            logHandler = StdoutLogHandler(true)
            setBatch(batch)
        }
    }

    @Test fun testPng() {
        eyes.open("testPng") {
            checkWindow("load")

            onView(withId(R.id.load_png))
                .perform(click())

            runBlocking { delay(1000) }

            // this does not throw error, but it records an incorrect screenshot
            checkWindow("png loaded")

            // causes error when hardware bitmap enabled
            // comment out to see previous incorrect screenshot in applitools
            check("png loaded -- region", region(withId(R.id.content)))
        }
    }

    @Test fun testSvg() {
        eyes.open("testSvg") {
            checkWindow("load")

            onView(withId(R.id.load_svg))
                .perform(click())

            runBlocking { delay(1000) }

            checkWindow("svg loaded")

            check("svg loaded -- region", region(withId(R.id.content)))
        }
    }

    // helper to auto close tests
    private fun Eyes.open(testName: String, block: Eyes.() -> Unit) {
        try {
            open("Applitools Coil Example", testName)
            block()
            close()
        } finally {
            abortIfNotClosed()
        }
    }

}