import io.qameta.allure.gradle.AllureExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.nio.charset.StandardCharsets

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.qameta.allure:allure-gradle:2.5")
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.10"
}

val allureVersion: String by extra { "2.7.0" }
val encoding: String by extra { StandardCharsets.UTF_8.name() }

group = "com.dkorobtsov"
version = "1.0-SNAPSHOT"

apply(plugin = "java")
apply(plugin = "io.qameta.allure")


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

configure<AllureExtension> {
    version = allureVersion
    autoconfigure = true
    aspectjweaver = true
    allureJavaVersion = allureVersion
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
    implementation("io.qameta.allure:allure-java-commons:$allureVersion")
    implementation("io.qameta.allure:allure-attachments:$allureVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaCompile> {
    options.isIncremental = true
    options.compilerArgs.add("-Xlint:all")
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
    options.encoding = encoding
}
