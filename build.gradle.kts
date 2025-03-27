plugins {
    id("java")
}

group = "oop.tegevusteplaneerija"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mnode.ical4j:ical4j:4.1.1")

}

tasks.test {
    useJUnitPlatform()
}