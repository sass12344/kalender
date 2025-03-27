package oop.tegevusteplaneerija.client;

import oop.tegevusteplaneerija.common.CalendarEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainClient extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an event using the common module
        CalendarEvent event = new CalendarEvent(
                2,
                "Client Meeting",
                "Discuss UI design",
                "2:00 PM",
                "3:00 PM"
        );

        Label label = new Label("Client started with event: " + event.getTitle());
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Calendar Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
