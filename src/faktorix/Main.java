package faktorix;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import faktorix.Ksiegowa.*;
import faktorix.Faktura.*;

import static javafx.application.Application.launch;

/*
TODO
- Muszę pododawć odpowiednie metody i pola do klas gdzie to pominąłem
  ale tylko to co przyda mi się w implementacji GUI
  głównie chodzi o takie metody biznesowe bo techincznie
  powinno wszystko być.
 */

//GUI method
public class Main{
    public static void main(String[] args) {





//        final String extentFile = "ekstensja.ser";

//        try {
//            var in = new ObjectInputStream(new FileInputStream(extentFile));
//            Osoba.wczytajEkstensje(in);
//            Faktura.wczytajEkstensje(in);
//            Firma.wczytajEkstensje(in);
//            ObslugaFirmy.wczytajEkstensje(in);
//            in.close();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println("Implementacja MAS");
//        RodzajKsiegowej[] rodzajKsiegowej = {RodzajKsiegowej.ZWYKLA};
//        Ksiegowa ksiegowa1 = new Ksiegowa("Anna1", "pass", List.of(rodzajKsiegowej));
//        Ksiegowa ksiegowa2 = new Ksiegowa("Basia1", "haslo_basia", List.of(rodzajKsiegowej));
//        Firma firma1 = new Firma(Firma.RodzajFirmy.ZOO, new DaneFirmy("123456789", "Faktorix", "adres 123"), "12309845621");
//        Firma firma2 = new Firma(Firma.RodzajFirmy.KOMANDYTOWA, new DaneFirmy("123456789", "Makronix", "adres 123"), "12309845621");
//        Faktura faktura1 = new Faktura("WA/2005", MetodaPlatnosci.KARTA, ksiegowa1, firma1);
//        Faktura faktura2 = new Faktura("WA/2001", MetodaPlatnosci.PRZELEW, ksiegowa2, firma1);
//        Faktura faktura3 = new Faktura("WA/2000", MetodaPlatnosci.GOTOWKA, ksiegowa1, firma2);

//        ObslugaFirmy obslugaFirmy1 = new ObslugaFirmy(
//                LocalDateTime.parse("2022-06-20T10:00"), LocalDateTime.parse("2022-06-20T11:00"),
//                ksiegowa1, firma1);



//        System.out.println("-------sprawdzenie asocjaci---------");
//        System.out.println("Faktury anii: " + ksiegowa1.getFaktury());
//        System.out.println("Faktury basii: " + ksiegowa2.getFaktury());
//        System.out.println("Faktury firmy faktorix:" + firma1.getFaktury());
//        System.out.println("Faktury firmy makronix" + firma2.getFaktury());
//
//        System.out.println();
//        faktura2.setFirma(firma2);


//        firma1 = Firma.getEkstensja().get(0);
//        ObslugaFirmy obslugaFirmy1 = ObslugaFirmy.getEkstensja().get(0);
//        System.out.println(ObslugaFirmy.getEkstensja());
//        firma1.usunObslugaFirmy(obslugaFirmy1);
//        Ksiegowa ksiegowa1 = (Ksiegowa) Osoba.getEkstensja().get("Anna1");
//        System.out.println(firma1.getObslugiFirmy());
//        System.out.println(ksiegowa1.getObslugiFirmy());
//        System.out.println(ObslugaFirmy.getEkstensja());
//
//        System.out.println("Faktury anii: " + ksiegowa1.getFaktury());
//        System.out.println("Faktury basii: " + ksiegowa2.getFaktury());
//        System.out.println("Faktury firmy faktorix:" + firma1.getFaktury());
//        System.out.println("Faktury firmy makronix" + firma2.getFaktury());

//        System.out.println(obslugaFirmy1);
//        System.out.println(ksiegowa1.getObslugiFirmy());
//        System.out.println(firma1.getObslugiFirmy());
//        System.out.println(ObslugaFirmy.getEkstensja());
//        System.out.println(ObslugaFirmy.getEkstensja().get(0).getKsiegowa().getObslugiFirmy().get(0).getFirma());
//        System.out.println("----------sprawdzenie ekstensji--------");
//        System.out.println(Ksiegowa.getEkstensja());
//        System.out.println(Faktura.getEkstensja());
//        System.out.println(Firma.getEkstensja().get(0).getFaktury());
//        System.out.println(ObslugaFirmy.getEkstensja());

//        try {
//            // Write the extent to the given stream
//            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
//            Osoba.zapiszEkstensje(out);
//            Faktura.zapiszEkstensje(out);
//            Firma.zapiszEkstensje(out);
//            ObslugaFirmy.zapiszEkstensje(out);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
