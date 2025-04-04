package oop.tegevusteplaneerija.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import oop.tegevusteplaneerija.common.CalendarEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

        ContextMenu contextMenu = new ContextMenu();
        MenuItem newEventItem = new MenuItem("Add Event");
        newEventItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    var dialog = new EventDialog(actionEvent, primaryStage);
                    var event = dialog.waitForResult();
                    if (event != null) events.getChildren().add(Widgets.EventWidget(event));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(newEventItem);

        root.setOnContextMenuRequested(e -> {
            contextMenu.show(root.getScene().getWindow(), e.getScreenX(), e.getScreenY());
        });

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Calendar Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
