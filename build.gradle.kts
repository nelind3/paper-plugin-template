plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "1.1.0"
}

group = "dk.nelind"
version = "${properties["plugin_version"]}+${properties["minecraft_version"]}"

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
        inputs.property("version", project.version)
        inputs.property("apiversion", project.properties["minecraft_version"].toString().subSequence(0,4))

        include("plugin.yml")
        filesMatching("plugin.yml") {
            expand(
                "version"    to project.version,
                "apiversion" to project.properties["minecraft_version"].toString().subSequence(0,4)
            )
        }
    }
}
