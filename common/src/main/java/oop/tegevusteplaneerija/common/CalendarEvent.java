package oop.tegevusteplaneerija.common;

public class CalendarEvent {
    private int id;
    private String title;
    private String description;

    public CalendarEvent(String title, String description) {
        this.title = title;
        this.description = description;

    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

