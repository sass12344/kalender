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
    implementation("org.xerial:sqlite-jdbc:3.41.2.1")
}