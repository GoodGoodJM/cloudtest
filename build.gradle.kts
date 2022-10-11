plugins {
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21" apply true
    id("org.springframework.boot") version "2.7.4" apply false
    kotlin("plugin.spring") version "1.6.21" apply false
    id("com.google.cloud.tools.jib") version "3.3.0" apply true
}


allprojects {
    group = "org.temp"

    repositories {
        mavenCentral()
    }
}

subprojects {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
    }

    apply {
        plugin("kotlin")
        plugin("com.google.cloud.tools.jib")
    }

    jib {
        to {
            image = "eclipse-temurin:17-jre-focal"
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}