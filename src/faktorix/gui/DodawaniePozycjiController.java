package faktorix.gui;

import faktorix.Firma;
import faktorix.Ksiegowa;
import faktorix.Pozycja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DodawaniePozycjiController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField nazwa;
    @FXML
    private ComboBox<Double> vat;
    @FXML
    private TextField netto;
    @FXML
    private TextField brutto;
    @FXML
    private Button anuluj;
    @FXML
    private Button dodaj;

    private Firma firma;
    private Ksiegowa ksiegowa;
    private String numerFaktury;
    private LocalDate wystawienieData;
    private LocalDate platnoscData;
    private Firma firmaWystawca;
    private List<Pozycja> pozycje;

    private String nazwaPozycji;
    private double stawkaVAT;
    private BigDecimal nettoPozycja;
    private BigDecimal bruttoPozycja;

    public void initialize(){
        List<Double> stawkiVat = Arrays.asList(0.05, 0.08, 0.23);
        ObservableList<Double> stawkiVatObservable = FXCollections.observableArrayList(stawkiVat);
        vat.setItems(stawkiVatObservable);
    }

    public void anuluj(ActionEvent event) throws IOException {
        // TODO zamknij okienko i anuluj dodawanie pozycji
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodawanieFaktury.fxml"));
        root = loader.load();
        DodawanieFakturyController dodawanieFakturyController = loader.getController();
        dodawanieFakturyController.ustawKontekst(ksiegowa, firma, pozycje, numerFaktury, wystawienieData, platnoscData, firmaWystawca);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void dodaj(ActionEvent event) {
        // TODO zweryfikuj dane, dodaj pozycjię, zamknij okienko i zaktualizuj tablę pozycji

        Pozycja pozycja = new Pozycja(nazwaPozycji, stawkaVAT, nettoPozycja);
    }

    public void ustawDane(Ksiegowa ksiegowa, Firma firma, List<Pozycja> pozycje, String numerFaktury, LocalDate dataWystawienia, LocalDate dataPlatnosci, Firma wystawcaFirma){
        this.firma = firma;
        this.ksiegowa = ksiegowa;
        this.numerFaktury = numerFaktury;
        this.wystawienieData = dataWystawienia;
        this.platnoscData = dataPlatnosci;
        this.firmaWystawca = wystawcaFirma;
        this.pozycje = pozycje;
        System.out.println(numerFaktury);
    }
}
