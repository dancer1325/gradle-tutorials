/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.7/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    // built-in by Gradle
    application

    // add Maven Publish plugin
    id("maven-publish")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    // libs.junit.jupiter               -- way to use in the subprojects / modules, the library declared
    // each time you type libs. ....., you get autocompletions by the IDE
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    // libs.junit.jupiter               -- way to use in the subprojects / modules, the library declared  '-' -- are converted to -> '.'
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

/* Register a task using the built-in 'Copy' task */
tasks.register<Copy>("copyTask") {
    from("source")
    into("target")
    include("*.war")
}

/* Dependencies between tasks */
tasks.register("hello") {
    doLast {
        println("Hello!")
    }
}
tasks.register("greet") {
    doLast {
        println("How are you?")
    }
    dependsOn("hello")      /* way to express dependency between tasks */
}


// Configure the plugin
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.gradle.tutorial"
            artifactId = "tutorial"
            version = "1.0"

            from(components["java"])
        }
    }
}