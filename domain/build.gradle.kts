plugins {
    id(Plugins.AndroidLibrary.id)
    id(Plugins.KotlinAndroid.id)
}

android {
    namespace = Configuration.domainModuleNameSpace
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
}

dependencies {

    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Paging.paging)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.junitExt)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Coroutines.test)
}