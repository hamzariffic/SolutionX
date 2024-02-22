
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
}

android {
    namespace = "com.example.solutionx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.solutionx"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation("com.google.android.libraries.platform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

//   Maps
    implementation("com.google.auth:google-auth-library-oauth2-http:0.25.0")
    implementation("com.google.http-client:google-http-client-jackson2:1.44.1")
    implementation("com.google.api-client:google-api-client:1.41.1")
    implementation("com.google.api-client:google-api-client-gson:1.41.1")
    implementation("com.google.apis:google-api-services-aqi:v1-rev20211201-1.31.0")

// OkHttp (required by Retrofit)
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    implementation("com.google.firebase:protolite-well-known-types:18.0.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout-compose-android:1.1.0-alpha13")
    implementation("com.google.android.gms:play-services-location:21.1.0")
    implementation("androidx.room:room-common:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}