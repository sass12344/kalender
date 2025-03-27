plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1" // selleks, et Azure saaks käivitada
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("com.sparkjava:spark-core:2.9.3")
    implementation("com.google.code.gson:gson:2.10.1")

}

application {
    mainClass.set("oop.tegevusteplaneerija.server.MainServer")
}
