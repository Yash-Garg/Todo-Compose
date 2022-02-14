plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.diffplug.spotless")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "dev.yashg.todoist"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {}
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions { jvmTarget = "1.8" }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.1.0" }
    packagingOptions { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

spotless {
    kotlin {
        ktfmt().kotlinlangStyle()
        target("**/*.kt")
        targetExclude("**/build/")
    }
    groovyGradle {
        target("**/*.gradle")
        targetExclude("**/build/")
    }
    format("xml") {
        target("**/*.xml")
        targetExclude("**/build/", ".idea/")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}

dependencies {
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.navigation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons.core)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
}
