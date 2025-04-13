plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    // kapt for Dagger Hilt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.spytify"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.spytify"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // mvvm lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // ViewModel
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//    // ViewModel utilities for Compose
//    implementation(libs.androidx.lifecycle.viewmodel.compose)
//    // LiveData
//    implementation(libs.androidx.lifecycle.livedata.ktx)
//    // Lifecycles only (without ViewModel or LiveData)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    // Lifecycle utilities for Compose
//    implementation(libs.androidx.lifecycle.runtime.compose)
//
//    // Saved state module for ViewModel
//    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    // Annotation processor for ViewModel
    kapt(libs.androidx.lifecycle.compiler)

    // Dagger - Hilt dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.fragment)
    kapt(libs.androidx.hilt.compiler)  // For Hilt components
}

kapt {
    correctErrorTypes = true
}
