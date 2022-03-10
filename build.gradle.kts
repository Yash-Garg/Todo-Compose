plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("com.diffplug.spotless") version "6.2.2" apply false
    kotlin("kapt") version "1.6.10" apply false
}

buildscript { dependencies { classpath(libs.build.dagger.agp) } }
