plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.diffplug.spotless")
}

val compose_version = "1.1.0"
val fragment_version = "1.4.1"
val nav_version = "2.4.1"

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
    composeOptions { kotlinCompilerExtensionVersion = compose_version }
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
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.runtime:runtime-rxjava2:$compose_version")
    implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
    implementation("androidx.compose.material:material-icons-core:$compose_version")
    implementation("androidx.compose.material:material-icons-extended:$compose_version")
    implementation("androidx.fragment:fragment-ktx:$fragment_version")
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-alpha02")
}
