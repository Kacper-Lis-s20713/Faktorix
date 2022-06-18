package faktorix.gui;

import faktorix.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class WyborFirmyController {

    @FXML
    private Button wybierzButton;
    @FXML
    private Button wylogujButton;
    @FXML
    private Label loginLabel;
    @FXML
    private TableColumn<Firma, String> nazwa;
    @FXML
    private TableColumn<Firma, String> NIP;
    @FXML
    private TableColumn<Firma, String> adres;
    @FXML
    private TableView<Firma> listaFirm;

    private ObservableList<Firma> daneFirm;

    public void initialize(){
        // TODO aktualizacja labela z nazwą użytkownika
        daneFirm = FXCollections.observableArrayList();

        nazwa.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getNazwaFirmy()));
        NIP.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getNIP()));
        adres.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getAdres()));

        daneFirm.addAll(Firma.getEkstensja());
        listaFirm.setItems(daneFirm);
    }

    public void wyloguj(ActionEvent event){
        // TODO powrót do ekranu logowania
        System.out.println("Wyloguj");
    }
    public void wybierzFirme(ActionEvent event) {
        // TODO po wybraniu firmy przejdź do listy faktur tej firmy
        Firma wybranaFirma = listaFirm.getSelectionModel().getSelectedItem();
        System.out.println("Wybierz firme: " + wybranaFirma.getDaneFirmy().getNazwaFirmy());
    }
}
