package oop.tegevusteplaneerija.client;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import oop.tegevusteplaneerija.common.CalendarEvent;


public class Widgets {

    public static Node EventWidget(CalendarEvent event) {
        Label label = new Label("%s: %s to %s".formatted(event.getTitle(), event.getStartTime(), event.getEndTime()));
        Label text = new Label(event.getDescription());

        Image image = new Image("event-end.png");
        Button button = new IconButton(image, image.getHeight(), image.getWidth());

        VBox info = new VBox(label, text);
        return new HBox(info, button);
    }
}
