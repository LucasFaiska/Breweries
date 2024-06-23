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