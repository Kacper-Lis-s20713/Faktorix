package faktorix.gui;

import faktorix.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.*;

public class GUI extends Application {

    public static void main(String[] args) {
        Firma firma1 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("1111111111", "Castorama", "adres 111"), "111111111111");
        Firma firma2 = new Firma(Firma.RodzajFirmy.KOMANDYTOWA, new DaneFirmy("2222222222", "Biedronka", "adres 222"), "222222222222");
        Firma firma3 = new Firma(Firma.RodzajFirmy.AKCYJNA, new DaneFirmy("3333333333", "Leroy Merlin", "adres 333"), "333333333333");
        Firma firma4 = new Firma(Firma.RodzajFirmy.JAWNA, new DaneFirmy("4444444444", "Media Markt", "adres 444"), "444444444444444");
        Firma firma5 = new Firma(Firma.RodzajFirmy.PARTNERSKA, new DaneFirmy("5555555555", "Jeronimo Martins sp. z o.o.", "adres 5555"), "555555555555555");
        Firma firma6 = new Firma(Firma.RodzajFirmy.PROSTAAKCYJNA, new DaneFirmy("6666666666", "Inwentorix", "adres 6666"), "66666666666666");
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PanelFaktur.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("WyborFirmy.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
