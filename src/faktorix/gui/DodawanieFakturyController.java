package faktorix.gui;

import faktorix.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DodawanieFakturyController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private VBox wystawca;
    @FXML
    private TextField numer;
    @FXML
    private DatePicker dataWystawienia;
    @FXML
    private DatePicker dataPlatnosci;
    @FXML
    private Button dodajPozycje;
    @FXML
    private Button dodajFakture;
    @FXML
    private Button anuluj;
    @FXML
    private Button usunPozycje;
    @FXML
    private TableView<Pozycja> tabelaPozycji;
    @FXML
    private TableColumn<Pozycja, String> nazwa;
    @FXML
    private TableColumn<Pozycja, String> podatek;
    @FXML
    private TableColumn<Pozycja, String> netto;
    @FXML
    private TableColumn<Pozycja, String> brutto;

    private Firma firma;
    private Ksiegowa ksiegowa;
    private String numerFaktury;
    private LocalDate wystawienieData;
    private LocalDate platnoscData;
    private Firma firmaWystawca;
    private ObservableList<Pozycja> danePozycje;
    private List<Pozycja> pozycje;

    public void initialize(){
        danePozycje = FXCollections.observableArrayList();

        nazwa.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNazwa()));
        podatek.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getStawkaVAT())));
        netto.setCellValueFactory(cellData ->
                new SimpleStringProperty(NumberFormat.getInstance(Locale.forLanguageTag("pl-PL")).format(cellData.getValue().getNetto().setScale(2, RoundingMode.HALF_UP)) + " PLN"));
        brutto.setCellValueFactory(cellData ->
                new SimpleStringProperty(NumberFormat.getInstance(Locale.forLanguageTag("pl-PL")).format(cellData.getValue().getBrutto().setScale(2, RoundingMode.HALF_UP)) + " PLN"));
        if(pozycje == null){
            pozycje = new ArrayList<>();
        }else{
            danePozycje.addAll(pozycje);
            tabelaPozycji.setItems(danePozycje);
        }
    }

    public void dodajPozycje(ActionEvent event) throws IOException{
        // TODO wyświetl okno dodawania pozycji
        this.aktualizujZmienne();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodawaniePozycji.fxml"));
        root = loader.load();
        DodawaniePozycjiController dodawaniePozycjiController = loader.getController();
        dodawaniePozycjiController.ustawDane(ksiegowa, firma, pozycje, numerFaktury, wystawienieData, platnoscData, firmaWystawca);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void dodajNowaPozycja(Pozycja pozycja){
        pozycje.add(pozycja);
        danePozycje.addAll(pozycje);
        tabelaPozycji.setItems(danePozycje);
    }

    public void aktualizujZmienne(){
        numerFaktury = numer.getCharacters().toString();
        wystawienieData = dataWystawienia.getValue();
        platnoscData = dataPlatnosci.getValue();
    }

    public void dodajFakture(ActionEvent event) {
        // TODO sprawdź prawidłowość danych i wyświetl informację o pomyślnym dodaniu faktury
        numerFaktury = numer.getCharacters().toString();
        wystawienieData = dataWystawienia.getValue();
        platnoscData = dataPlatnosci.getValue();
    }

    public void anuluj(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PanelFaktur.fxml"));
        root = loader.load();
        PanelFakturController panelFakturController = loader.getController();
        panelFakturController.wybierzFirma(ksiegowa, firma);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void usunPozycje(ActionEvent event) {
        // TODO usunięcie pozycji z faktury i aktualizacja tabeli pozycji
    }

    public void ustawKontekst(Firma firma, Ksiegowa ksiegowa) {
        this.firma = firma;
        this.ksiegowa = ksiegowa;
    }

    public void ustawKontekst(Ksiegowa ksiegowa, Firma firma, List<Pozycja> pozycje, String numerFaktury, LocalDate wystawienieData, LocalDate platnoscData, Firma firmaWystawca) {
        this.firma = firma;
        this.ksiegowa = ksiegowa;
        this.numerFaktury = numerFaktury;
        this.wystawienieData = wystawienieData;
        this.platnoscData = platnoscData;
        this.firmaWystawca = firmaWystawca;
        this.pozycje = pozycje;

        numer.setText(numerFaktury);
        dataWystawienia.setValue(wystawienieData);
        dataPlatnosci.setValue(platnoscData);
    }
}
