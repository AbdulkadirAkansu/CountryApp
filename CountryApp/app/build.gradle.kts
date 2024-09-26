plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id ("com.google.devtools.ksp")
    id ("kotlin-kapt")
}

android {
    namespace = "com.akansu.countryapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.akansu.countryapp"
        minSdk = 34
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    dataBinding{
        enable = true
    }
}

dependencies {

    val nav_version = "2.7.2"
    val lifecycle_version = "2.6.2"
    val supportVersion = "28.0.0"
    val retrofitVersion = "2.9.0"
    val glideVersion = "4.15.1"
    val roomVersion = "2.5.2"
    val preferencesVersion = "1.2.1"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    //room
    implementation ("androidx.room:room-runtime:$roomVersion")
    annotationProcessor ("androidx.room:room-compiler:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")

    //coroutines for threads
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    // navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //rxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    //glide
    implementation ("com.github.bumptech.glide:glide:$glideVersion")

    //noinspection GradleCompatible,GradleCompatible
    implementation ("com.android.support:palette-v7:$supportVersion")
    //noinspection GradleCompatible
    implementation ("com.android.support:design:$supportVersion")
    //preference
    implementation ("androidx.preference:preference-ktx:$preferencesVersion")

    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")


}

