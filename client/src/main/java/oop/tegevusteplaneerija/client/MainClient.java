package oop.tegevusteplaneerija.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import oop.tegevusteplaneerija.common.CalendarEvent;
import oop.tegevusteplaneerija.common.DatabaseManager;

import java.sql.SQLException;

public class MainClient extends Application {

    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    private static DatabaseManager startDatabase() throws SQLException {
        DatabaseManager dbm = new DatabaseManager("client.db");
        dbm.init();
        dbm.insertEvent(1, "Kliendi sündmus", "lihtsalt prooviks");
        return dbm;
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
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

        DatabaseManager dbm = startDatabase();
        dbm.printAll();
        primaryStage.setTitle("tere");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
