package oop.tegevusteplaneerija.client;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import oop.tegevusteplaneerija.common.CalendarEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClient extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an event using the common module
        CalendarEvent event1 = new CalendarEvent(
                2,
                "Client Meeting",
                "Discuss UI design",
                "2:00 PM",
                "3:00 PM"
        );
        CalendarEvent event2 = new CalendarEvent(
                3,
                "foo",
                "bar",
                "4:00 PM",
                "5:00 PM"
        );

        List<Node> event = Arrays.asList(event1, event2).stream().map(Widgets::EventWidget).toList();

        VBox events = new VBox();
        BorderPane root = new BorderPane(events);
        events.getChildren().addAll(event);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Calendar Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
