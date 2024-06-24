plugins {
    id(Plugins.AndroidLibrary.id)
    id(Plugins.KotlinAndroid.id)
    id(Plugins.Kapt.id)
}

android {
    namespace = Configuration.dataModuleNameSpace
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = Configuration.javaVersion
        targetCompatibility = Configuration.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }

    android.buildFeatures.buildConfig = true
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependencies.OkHttp.okhttp)
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.gsonConverter)
    implementation(Dependencies.Hilt.hilt)
    implementation(Dependencies.Paging.paging)
    kapt(Dependencies.Hilt.hiltCompiler)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.junitExt)
    testImplementation(Dependencies.OkHttp.mockWebServer)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Coroutines.test)
}