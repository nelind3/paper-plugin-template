plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "1.1.0"
}

group = "dk.nelind"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${properties["minecraft_version"]}-${properties["paper_api_release"]}")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    runServer {
        minecraftVersion(project.properties["minecraft_version"].toString())
        dependsOn(build)
    }

    processResources {
        include("plugin.yml")
    }
}
