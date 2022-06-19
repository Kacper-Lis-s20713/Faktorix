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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class WyborFirmyController {

    private Stage stage;
    private Scene scene;
    private Parent root;
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
    private Ksiegowa ksiegowa;

    public void initialize(){
        daneFirm = FXCollections.observableArrayList();

        nazwa.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getNazwaFirmy()));
        NIP.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getNIP()));
        adres.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDaneFirmy().getAdres()));
    }

    public void wyloguj(ActionEvent event) throws IOException {
        System.out.println("Wyloguj");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        root = loader.load();
//        LoginScreenController loginScreenController = loader.getController();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void wybierzFirme(ActionEvent event) throws IOException{
        Firma wybranaFirma = listaFirm.getSelectionModel().getSelectedItem();
        if(wybranaFirma != null){
            System.out.println("Wybierz firme: " + wybranaFirma.getDaneFirmy().getNazwaFirmy());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PanelFaktur.fxml"));
            root = loader.load();
            PanelFakturController panelFakturController = loader.getController();
            panelFakturController.wybierzFirma(ksiegowa, wybranaFirma);
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void zaloguj(Ksiegowa wybranaKsiegowa) {
        this.ksiegowa = wybranaKsiegowa;
        loginLabel.setText("Zalogowano jako: " + ksiegowa.getLogin());

        // wypełnienie tabeli firm danymi
        daneFirm.addAll(ksiegowa.getFirmy());
        listaFirm.setItems(daneFirm);
    }
}
