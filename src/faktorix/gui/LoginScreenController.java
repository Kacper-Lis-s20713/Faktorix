package faktorix.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import faktorix.*;

import java.io.IOException;
import java.util.*;

public class LoginScreenController{

    @FXML
    private Button loginButton;
    @FXML
    private ListView<String> usersTable = new ListView<>();

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void initialize(){
        Map<String, Osoba> osoby = Osoba.getEkstensja();
        List<String> loginy = new ArrayList<>(osoby.keySet());
        ObservableList<String> loginyLista = FXCollections.observableArrayList(loginy);
        usersTable.setItems(loginyLista);
    }

    public void login(ActionEvent event) throws IOException {
        Ksiegowa wybranaKsiegowa = (Ksiegowa) Osoba.getOsoba(usersTable.getSelectionModel().getSelectedItem());
        if(wybranaKsiegowa != null) {
            System.out.println(wybranaKsiegowa.getLogin());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WyborFirmy.fxml")); //initialize
            root = loader.load();
            WyborFirmyController wyborFirmyController = loader.getController();
            wyborFirmyController.zaloguj(wybranaKsiegowa);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}
