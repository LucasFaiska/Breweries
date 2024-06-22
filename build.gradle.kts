import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ClasspathDependencies.androidGradlePlugin)
        classpath(ClasspathDependencies.kotlinGradlePlugin)
        classpath(ClasspathDependencies.hiltGradlePlugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

subprojects {
    apply(plugin = Plugins.KotlinAndroid.id)

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            languageVersion = Configuration.kotlinVersion
        }
    }
}