package faktorix.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DodawaniePozycjiController {
    @FXML
    public TextField nazwa;
    @FXML
    public ComboBox vat;
    @FXML
    public TextField netto;
    @FXML
    public TextField brutto;
    @FXML
    public Button anuluj;
    @FXML
    public Button dodaj;

    public void anuluj(ActionEvent event) {
        // TODO zamknij okienko i anuluj dodawanie pozycji
    }

    public void dodaj(ActionEvent event) {
        // TODO zweryfikuj dane, dodaj pozycjię, zamknij okienko i zaktualizuj tablę pozycji
    }
}
