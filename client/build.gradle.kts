plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

javafx {
    version = "24"
    modules = listOf("javafx.controls", "javafx.fxml")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    // JavaFX dependencies for a modern desktop UI

}

application {
    mainClass.set("oop.tegevusteplaneerija.client.MainClient")
}