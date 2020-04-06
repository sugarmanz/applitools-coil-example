# Applitools Coil Example

This repository was created to reproduce an error recording screenshots with hardware enabled images loaded by [Coil](https://github.com/coil-kt/coil).

When loading bitmaps using coil, if the coil request is not configured to disable hardware bitmaps, then an error is thrown when attempting to check the region. If the test only checks the window, then the test will not crash, but the screenshot will be incorrect.

## Run

Simply open project with Android Studio and it should auto-detect the Gradle build.

## Run test

Set the Applitools API key [here](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/androidTest/java/com/example/applitoolscoilexample/MainActivityTest.kt#L31) and launch MainActitityTest.

#### Crash when checking region

Disable hardware bitmaps by uncommenting [this line](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/main/java/com/example/applitoolscoilexample/MainActivity.kt#L48). Doing this will ensure the tests run properly and record the correct screenshots.

![crash](https://github.com/sugarmanz/applitools-coil-example/blob/master/docs/hardware%20bitmaps%20error.png?raw=true)

#### Incorrect screenshot

Comment out [this line](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/androidTest/java/com/example/applitoolscoilexample/MainActivityTest.kt#L51) to observe the test recording an incorrect screenshot.

![incorrect screenshot](https://github.com/sugarmanz/applitools-coil-example/blob/master/docs/incorrect%20screenshot.png?raw=true)


## Bonus issue

If you run the app, you will be able to observe a drop-shadow around the container that is from the [set elevation](https://github.com/sugarmanz/applitools-coil-example/blob/master/app/src/main/res/layout/activity_main.xml#L16). The screenshots recorded in Applitools do not have this drop-shadow/elevation.

#### Actual device screenshot
![actual screenshot](https://github.com/sugarmanz/applitools-coil-example/blob/master/docs/actual%20screenshot.png?raw=true)

#### Applitools screenshot
![image of no drop shadow](https://github.com/sugarmanz/applitools-coil-example/blob/master/docs/missing%20drop%20shadow.png?raw=true)
