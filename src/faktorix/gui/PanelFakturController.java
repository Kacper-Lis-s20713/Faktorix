package faktorix.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PanelFakturController {
    @FXML
    public Label firmaNapis;
    @FXML
    public TableView tabelaFaktur;
    @FXML
    public TableColumn numer;
    @FXML
    public TableColumn wystawca;
    @FXML
    public TableColumn netto;
    @FXML
    public TableColumn brutto;
    @FXML
    public Button wroc;
    @FXML
    public Button duplikuj;
    @FXML
    public Button usun;
    @FXML
    public Button dodaj;

    public void initialize(){

    }

    public void wroc(ActionEvent event) {
        // TODO wróć do ekranu z wyborem firm
    }

    public void duplikuj(ActionEvent event) {
        // TODO otwórz okienko dodawania faktury z danymi wybranej faktury
    }

    public void usun(ActionEvent event) {
        // TODO usun fakture i wyswietl komunikat o pomyslnym usunieciu oraz aktualizacja tabeli
    }

    public void dodaj(ActionEvent event) {
        // TODO wyswietl okienko dodawania faktury
    }
}
