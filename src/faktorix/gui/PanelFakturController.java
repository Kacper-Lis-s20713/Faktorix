package faktorix.gui;

import faktorix.Faktura;
import faktorix.Firma;
import faktorix.Ksiegowa;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class PanelFakturController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label firmaNapis;
    @FXML
    private TableView<Faktura> tabelaFaktur;
    @FXML
    private TableColumn<Faktura, String> numer;
    @FXML
    private TableColumn<Faktura, String> wystawca;
    @FXML
    private TableColumn<Faktura, String> netto;
    @FXML
    private TableColumn<Faktura, String> brutto;
    @FXML
    private Button wroc;
    @FXML
    private Button duplikuj;
    @FXML
    private Button usun;
    @FXML
    private Button dodaj;

    private ObservableList<Faktura> daneFaktury;
    private Ksiegowa ksiegowa;
    private Firma firma;

    public void initialize(){
        System.out.println("Wyswietlono panel faktur");
        daneFaktury = FXCollections.observableArrayList();


        // TODO poprawa wyświetlania kwoty
        numer.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNumer()));
        wystawca.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getWystawca().getDaneFirmy().getNazwaFirmy()));
        netto.setCellValueFactory(cellData ->
                new SimpleStringProperty(NumberFormat.getInstance(Locale.forLanguageTag("pl-PL")).format(cellData.getValue().getNetto().setScale(2, RoundingMode.HALF_UP)) + " PLN"));
        brutto.setCellValueFactory(cellData ->
                new SimpleStringProperty(NumberFormat.getInstance(Locale.forLanguageTag("pl-PL")).format(cellData.getValue().getBrutto().setScale(2, RoundingMode.HALF_UP)) + " PLN"));
    }

    public void wroc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WyborFirmy.fxml"));
        root = loader.load();
        WyborFirmyController wyborFirmyController = loader.getController();
        wyborFirmyController.zaloguj(ksiegowa);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void duplikuj(ActionEvent event) {
        // TODO otwórz okienko dodawania faktury z danymi wybranej faktury
    }

    public void usun(ActionEvent event) {
        // TODO usun fakture i wyswietl komunikat o pomyslnym usunieciu oraz aktualizacja tabeli. Usuwanie musi być trwałe czyli usuwać z ekstensji.
    }

    public void dodaj(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodawanieFaktury.fxml"));
        root = loader.load();
        DodawanieFakturyController dodawanieFakturyController = loader.getController();
        dodawanieFakturyController.ustawKontekst(firma, ksiegowa);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void wybierzFirma(Ksiegowa ksiegowa, Firma wybranaFirma) {
        this.ksiegowa = ksiegowa;
        this.firma = wybranaFirma;
        firmaNapis.setText("Faktury firmy: " + wybranaFirma.getDaneFirmy().getNazwaFirmy());
        daneFaktury.addAll(firma.getFaktury());
        tabelaFaktur.setItems(daneFaktury);
    }
}
