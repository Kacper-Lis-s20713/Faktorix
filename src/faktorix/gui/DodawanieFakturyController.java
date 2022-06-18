package faktorix.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DodawanieFakturyController {
    @FXML
    public VBox wystawca;
    @FXML
    public TextField numer;
    @FXML
    public DatePicker dataWystawienia;
    @FXML
    public DatePicker dataPlatnosci;
    @FXML
    public Button dodajPozycje;
    @FXML
    public Button dodajFakture;
    @FXML
    public Button anuluj;
    @FXML
    public Button usunPozycje;

    public void dodajPozycje(ActionEvent event) {
        // TODO wyświetl okno dodawania pozycji
    }

    public void dodajFakture(ActionEvent event) {
        // TODO sprawdź prawidłowość danych i wyświetl informację o pomyślnym dodaniu faktury
    }

    public void anuluj(ActionEvent event) {
        // TODO powrót do panelu faktur
    }

    public void usunPozycje(ActionEvent event) {
        // TODO usunięcie pozycji z faktury i aktualizacja tabeli pozycji
    }
}
