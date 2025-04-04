plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    // Add server-specific dependencies, for example, a REST API framework like Javalin or Spring Boot
    // implementation("io.javalin:javalin:4.6.4")
}

application {
    mainClass.set("oop.tegevusteplaneerija.server.MainServer")
}