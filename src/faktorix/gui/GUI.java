package faktorix.gui;

import faktorix.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class GUI extends Application {
    private static final String extentFile = "ekstensja.ser";
    public static void main(String[] args) {
        try {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Osoba.wczytajEkstensje(in);
            Faktura.wczytajEkstensje(in);
            Firma.wczytajEkstensje(in);
            ObslugaFirmy.wczytajEkstensje(in);
            Biuro.wczytajEkstensje(in);
            Umowa.wczytajEkstensje(in);
            Pracownik.wczytajEkstensje(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Dane zawarte już w ekstensji
//        Ksiegowa.RodzajKsiegowej[] rodzajKsiegowej = {Ksiegowa.RodzajKsiegowej.ZWYKLA, Ksiegowa.RodzajKsiegowej.KADROWA};
//        Ksiegowa ksiegowa1 = new Ksiegowa("Anna1", "pass", List.of(rodzajKsiegowej));
//        Ksiegowa ksiegowa2 = new Ksiegowa("Basia1", "haslo_basia", List.of(rodzajKsiegowej));
//        Ksiegowa ksiegowa3 = new Ksiegowa("Gosia", "haslo_gosia", Arrays.asList(Ksiegowa.RodzajKsiegowej.KADROWA));
//        Ksiegowa ksiegowa4 = new Ksiegowa("Magda", "haslo_magda", Arrays.asList(Ksiegowa.RodzajKsiegowej.ZWYKLA));
//        Ksiegowa ksiegowa5 = new Ksiegowa("Marcel", "haslo_marcel", Arrays.asList(Ksiegowa.RodzajKsiegowej.KADROWA));
//        Firma firma1 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("123456789", "Faktorix", "adres 123"), "12309845621");
//        Firma firma2 = new Firma(Firma.RodzajFirmy.KOMANDYTOWA, new DaneFirmy("123456789", "Makronix", "adres 123"), "12309845621");
//        Firma firma3 = new Firma(Firma.RodzajFirmy.AKCYJNA, new DaneFirmy("3333333333", "Leroy Merlin", "adres 333"), "333333333333");
//        Firma firma4 = new Firma(Firma.RodzajFirmy.JAWNA, new DaneFirmy("4444444444", "Media Markt", "adres 444"), "444444444444444");
//        Firma firma5 = new Firma(Firma.RodzajFirmy.PARTNERSKA, new DaneFirmy("5555555555", "Jeronimo Martins", "adres 5555"), "555555555555555");
//        Firma firma6 = new Firma(Firma.RodzajFirmy.PROSTAAKCYJNA, new DaneFirmy("6666666666", "Inwentorix", "adres 6666"), "66666666666666");
//        Firma wystawca1 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("7777777777", "Castorama", "adres 777"), "777777777777");
//        Firma wystawca2 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("8888888888", "Oskroba", "adres 888"), "8888888888888");
//        ObslugaFirmy obslugaFirmy1 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa1, firma1);
//        ObslugaFirmy obslugaFirmy2 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa1, firma2);
//        ObslugaFirmy obslugaFirmy3 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa1, firma3);
//        ObslugaFirmy obslugaFirmy4 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa2, firma1);
//        ObslugaFirmy obslugaFirmy5 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa2, firma2);
//        ObslugaFirmy obslugaFirmy6 = new ObslugaFirmy(LocalDateTime.now(), LocalDateTime.now(), ksiegowa2, firma3);
//        Pozycja pozycja1 = new Pozycja("Beton", 0.23, new BigDecimal(405.50));
//        Pozycja pozycja2 = new Pozycja("Pizza", 0.08, new BigDecimal(34));
//        Pozycja pozycja3 = new Pozycja("Bulka", 0.05, new BigDecimal(2));
//        List<Pozycja> pozycje = new ArrayList<>(Arrays.asList(pozycja1,pozycja2,pozycja3));
//        Faktura faktura1 = new Faktura("WA/2000", Faktura.MetodaPlatnosci.KARTA, ksiegowa1, firma1, pozycje, wystawca1);
//        Faktura faktura2 = new Faktura("WA/2001", Faktura.MetodaPlatnosci.PRZELEW, ksiegowa2, firma1, pozycje, wystawca1);
//        Faktura faktura3 = new Faktura("WA/2002", Faktura.MetodaPlatnosci.GOTOWKA, ksiegowa1, firma2, pozycje, wystawca1);
//        Faktura faktura4 = new Faktura("WA/2003", Faktura.MetodaPlatnosci.GOTOWKA, ksiegowa1, firma2, pozycje, wystawca2);
//        Faktura faktura5 = new Faktura("WA/2004", Faktura.MetodaPlatnosci.KARTA, ksiegowa1, firma2, pozycje, wystawca2);
//        Faktura faktura6 = new Faktura("WA/2005", Faktura.MetodaPlatnosci.PRZELEW, ksiegowa1, firma2, pozycje, wystawca2);
//        System.out.println(faktura1.getNetto());
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Faktorix");
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop(){
        try {
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Osoba.zapiszEkstensje(out);
            Faktura.zapiszEkstensje(out);
            Firma.zapiszEkstensje(out);
            ObslugaFirmy.zapiszEkstensje(out);
            Biuro.zapiszEkstensje(out);
            Umowa.zapiszEkstensje(out);
            Pracownik.zapiszEkstensje(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
