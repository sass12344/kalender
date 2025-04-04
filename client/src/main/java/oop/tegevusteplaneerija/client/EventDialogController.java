package oop.tegevusteplaneerija.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.tegevusteplaneerija.common.CalendarEvent;

import java.util.concurrent.ThreadLocalRandom;


public class EventDialogController {
    @FXML
    private TextField titleField;

    @FXML
    private TextField descField;

    @FXML
    private TextField startField;

    @FXML
    private TextField endField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton;

    private CalendarEvent result;

    @FXML
    void cancel() {
        result = null;

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ok() {
        String title = titleField.getText();
        String desc = descField.getText();
        String start = startField.getText();
        String end = endField.getText();

        // TODO: id loogika
        var event = new CalendarEvent(ThreadLocalRandom.current().nextInt(), title, desc, start, end);
        result = event;

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public CalendarEvent getResult() {
        return result;
    }
}
