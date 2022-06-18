package faktorix.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import faktorix.*;

import java.util.*;

public class LoginScreenController{

    @FXML
    public Button loginButton;
    @FXML
    private ListView<String> usersTable = new ListView<>();


    public void initialize(){
        Ksiegowa ksiegowa1 = new Ksiegowa("Ania12", "Pass123", Arrays.asList(Ksiegowa.RodzajKsiegowej.ZWYKLA));
        Ksiegowa ksiegowa2 = new Ksiegowa("Basia", "Pass123", Arrays.asList(Ksiegowa.RodzajKsiegowej.ZWYKLA));
        Ksiegowa ksiegowa3 = new Ksiegowa("Barbara2005", "Pass123", Arrays.asList(Ksiegowa.RodzajKsiegowej.ZWYKLA));

        Map<String, Osoba> osoby = Osoba.getEkstensja();
        List<String> loginy = new ArrayList<>(osoby.keySet());
        ObservableList<String> loginyLista = FXCollections.observableArrayList(loginy);
        usersTable.setItems(loginyLista);
    }

    public void login(ActionEvent actionEvent) {
        // TODO Po wybraniu konta przejdź do wyboru firmy
        Ksiegowa wybranaKsiegowa = (Ksiegowa) Osoba.getOsoba(usersTable.getSelectionModel().getSelectedItem());
        if(wybranaKsiegowa != null){
            System.out.println(wybranaKsiegowa.getLogin());
        }
    }
}
