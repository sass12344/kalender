package oop.tegevusteplaneerija.server;

import oop.tegevusteplaneerija.common.CalendarEvent;

public class MainServer {
    public static void main(String[] args) {
        // Create an event using the common module
        CalendarEvent event = new CalendarEvent(
                1,
                "Server Meeting",
                "Team sync-up meeting",
                "10:00 AM",
                "11:00 AM"
        );
        System.out.println("Server started with event: " + event);
    }
}
