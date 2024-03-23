// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

}

buildscript {
    extra.set("compileSdkVersion", 34)
    extra.set("minSdkVersion", 26)
    extra.set("targetSdkVersion", 34)
}