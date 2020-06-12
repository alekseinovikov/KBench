val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koltin_cli_version: String by project
val junit_version: String by project

plugins {
    application
    kotlin("jvm") version "1.3.72"
}

group = "me.freedom4live.kbench"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.cio.EngineMain"
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")

    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlin_version")
    testImplementation("org.junit.jupiter:junit-jupiter:$junit_version")
}

kotlin {
    sourceSets {
        main {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:$koltin_cli_version")
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}