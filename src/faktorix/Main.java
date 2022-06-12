package faktorix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import faktorix.Ksiegowa.*;
import faktorix.Faktura.*;

//GUI method
public class Main{
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("gui/sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }

    public static void main(String[] args) {
//        launch(args);

        final String extentFile = "ekstensja.ser";

        try {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Ksiegowa.wczytajEkstensje(in);
            Faktura.wczytajEkstensje(in);
            Firma.wczytajEkstensje(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Implementacja MAS");
        RodzajKsiegowej[] rodzajKsiegowej = {RodzajKsiegowej.ZWYKLA};
//        Ksiegowa ksiegowa1 = new Ksiegowa("Anna1", "pass", List.of(rodzajKsiegowej));
//        Ksiegowa ksiegowa2 = new Ksiegowa("Basia1", "haslo_basia", List.of(rodzajKsiegowej));
//        Firma firma1 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("123456789", "Faktorix", "adres 123"), "12309845621");
//        Firma firma2 = new Firma(Firma.RodzajFirmy.KOMANDYTOWA, new DaneFirmy("123456789", "Makronix", "adres 123"), "12309845621");
//        Faktura faktura1 = new Faktura("WA/2005", MetodaPlatnosci.KARTA, ksiegowa1, firma1);
//        Faktura faktura2 = new Faktura("WA/2001", MetodaPlatnosci.PRZELEW, ksiegowa2, firma1);
//        Faktura faktura3 = new Faktura("WA/2000", MetodaPlatnosci.GOTOWKA, ksiegowa1, firma2);

        System.out.println("-------sprawdzenie asocjaci---------");
//        System.out.println("Faktury anii: " + ksiegowa1.getFaktury());
//        System.out.println("Faktury basii: " + ksiegowa2.getFaktury());
//        System.out.println("Faktury firmy faktorix:" + firma1.getFaktury());
//        System.out.println("Faktury firmy makronix" + firma2.getFaktury());
//
//        System.out.println();
//        faktura2.setFirma(firma2);
//
//        System.out.println("Faktury anii: " + ksiegowa1.getFaktury());
//        System.out.println("Faktury basii: " + ksiegowa2.getFaktury());
//        System.out.println("Faktury firmy faktorix:" + firma1.getFaktury());
//        System.out.println("Faktury firmy makronix" + firma2.getFaktury());
        System.out.println("----------sprawdzenie ekstensji--------");
        System.out.println(Ksiegowa.getEkstensja());
        System.out.println(Faktura.getEkstensja());
        System.out.println(Firma.getEkstensja().get(0).getDaneFirmy().getNazwaFirmy());

//        try {
//            // Write the extent to the given stream
//            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
//            Ksiegowa.zapiszEkstensje(out);
//            Faktura.zapiszEkstensje(out);
//            Firma.zapiszEkstensje(out);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
