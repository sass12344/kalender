plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    // iCal4j for handling iCalendar (.ics) files
    implementation("org.mnode.ical4j:ical4j:4.1.1")
    // SQLite JDBC driver for database operations
    implementation("org.xerial:sqlite-jdbc:3.49.1.0")
    implementation("org.slf4j:slf4j-simple:2.0.17")
}