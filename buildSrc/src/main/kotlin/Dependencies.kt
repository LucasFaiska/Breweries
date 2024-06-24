import org.gradle.api.JavaVersion

object Configuration {

    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"

    const val kotlinVersion = "1.9"

    const val compileSdk = 34
    const val targetSdk = 34
    const val minSdk = 24

    const val versionCode = 1
    const val versionName = "1.0"

    const val applicationId = "com.lucas.breweries"
    const val applicationNameSpace = "com.lucas.breweries"
    const val dataModuleNameSpace = "com.lucas.breweries.data"
    const val coreModuleNameSpace = "com.lucas.breweries.core"
    const val domainModuleNameSpace = "com.lucas.breweries.domain"
}

object Plugins {

    object AndroidApplication {
        const val id = "com.android.application"
    }

    object KotlinAndroid {
        const val id = "org.jetbrains.kotlin.android"
    }

    object AndroidLibrary {
        const val id = "com.android.library"
    }

    object Kapt {
        const val id = "kotlin-kapt"
    }

    object Hilt {
        const val id = "dagger.hilt.android.plugin"
    }

}

object ClasspathDependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:8.2.2"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.51"
}

object Dependencies {

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.5.1"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.6.0"
        const val mockk = "io.mockk:mockk:1.13.11"
        const val turbine = "app.cash.turbine:turbine:1.1.0"
        const val roboletric = "org.robolectric:robolectric:4.12.2"
    }

    object Retrofit {
        private const val version = "2.11.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Hilt {
        private const val version = "2.51.1"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.2.0"
        const val hiltTesting = "com.google.dagger:hilt-android-testing:$version"
    }

    object OkHttp {
        private const val version = "4.12.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Coroutines {
        private const val version = "1.8.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Compose {
        private const val version = "1.6.8"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val test = "androidx.compose.ui:ui-test-junit4:$version"
        const val testManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }

    object ComposeNavigation {
        private const val version = "2.7.7"
        const val navigation = "androidx.navigation:navigation-compose:$version"
    }

    object Paging {
        private const val version = "3.3.0"
        const val paging = "androidx.paging:paging-runtime:$version"
        const val pagingCompose = "androidx.paging:paging-compose:$version"
    }

    object ViewModelLifecycle {
        private const val version = "2.8.2"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }
}