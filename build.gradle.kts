import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.dokka") version "1.9.20"
}

val meepMeepVersion = "1.0-SNAPSHOT"
val pomUrl = "https://github.com/rh-robotics/MeepMeep"
val pomScmUrl = "https://github.com/rh-robotics/MeepMeep"
val pomIssueUrl = "https://github.com/rh-robotics/MeepMeep/issues"
val pomDesc = "https://github.com/rh-robotics/MeepMeep"
val githubRepo = "rh-robotics/MeepMeep"
val githubReadme = "README.md"

repositories {
    maven(url = "https://maven.brott.dev/")
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    api("com.acmerobotics.roadrunner:core:0.5.6")
}

sourceSets["main"].java {
    srcDir("src/main/kotlin")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>("meepmeep") {
            groupId = "org.rowlandhall.meepmeep"
            artifactId = "meepmeep"
            version = meepMeepVersion

            from(components["java"])
            artifact(sourcesJar)

            pom {
                packaging = "jar"
                name.set(rootProject.name)
                description.set(pomDesc)
                url.set(pomUrl)
                scm {
                    url.set(pomScmUrl)
                }
            }
        }
    }

    repositories {
        maven {
            url = uri("${layout.buildDirectory}/repository")
        }
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.compilerOptions {
    jvmTarget.set(JvmTarget.JVM_17)
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.compilerOptions {
    jvmTarget.set(JvmTarget.JVM_17)
}