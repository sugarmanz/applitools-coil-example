# Applitools Coil Example

This repository was created to reproduce an error recording screenshots with hardware enabled images loaded by [Coil](https://github.com/coil-kt/coil).

When loading bitmaps using coil, if the coil request is not configured to disable hardware bitmaps, then an error is thrown when attempting to check the region. If the test only checks the window, then the test will not crash, but the screenshot will be incorrect.

## Run

Simply open project with Android Studio and it should auto-detect the Gradle build.

## Run test

Set the Applitools API key [here](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/androidTest/java/com/example/applitoolscoilexample/MainActivityTest.kt#L31) and launch MainActitityTest.

Disable hardware bitmaps by uncommenting [this line](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/main/java/com/example/applitoolscoilexample/MainActivity.kt#L48). Doing this will ensure the tests run properly and record the correct screenshots.

Comment out [this line](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/androidTest/java/com/example/applitoolscoilexample/MainActivityTest.kt#L51) to observe the test recording an incorrect screenshot.

## Bonus issue

If you run the app, you will be able to observe a drop-shadow around the container that is from the [set elevation](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/main/res/layout/activity_main.xml#L16). The screenshots recorded in Applitools do not have this drop-shadow/elevation.
