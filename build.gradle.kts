val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposedVersion = "0.30.2"
val hikariCpVersion = "4.0.3"

plugins {
    application
    kotlin("jvm") version "1.5.0"
}

group = "com.volodya"
version = "0.0.1"
application {
    mainClass.set("com.volodya.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    runtimeOnly("org.postgresql:postgresql:42.2.20")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("com.zaxxer:HikariCP:$hikariCpVersion")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}