package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faktura implements Serializable {
    public enum MetodaPlatnosci{
        KARTA, GOTOWKA, PRZELEW;
    }

    private String numer; //{unique} TODO
    private MetodaPlatnosci metodaPlatnosci;
    private List<Pozycja> pozycje = new ArrayList<>();

    // Połączenia asocjacji
    private Ksiegowa ksiegowa; // Nie ustawiam null, ponieważ zakładam, że faktura nie może powstać bez księgowej
    private Firma firma;
    private Firma wystawca;

    // Ekstensja Klasy
    private static Map<String, Faktura> ekstensja = new HashMap<>();

    public Faktura(String numer, MetodaPlatnosci metodaPlatnosci, Ksiegowa ksiegowa, Firma firma, List<Pozycja> pozycje, Firma wystawca) {
        this.numer = numer;
        this.metodaPlatnosci = metodaPlatnosci;
        this.pozycje = pozycje;
        this.wystawca = wystawca;
        // TODO: ksiegowa nie moze byc null
        this.ksiegowa = ksiegowa;
        ksiegowa.addFaktura(this);

        this.firma = firma;
        firma.addFaktura(this);
        ekstensja.put(numer, this);
    }

    // Asocjacja faktury z Księgową i Firmą
    public void setKsiegowa(Ksiegowa nowaksiegowa) {
        if (ksiegowa != null) {
            ksiegowa.usunFakture(this);
        }
        ksiegowa = nowaksiegowa;
        ksiegowa.addFaktura(this);
    }

    public void setFirma(Firma nowafirma) {
        if(firma != null){
            firma.usunFakture(this);
        }
        firma = nowafirma;
        firma.addFaktura(this);
    }
    // TODO sprawdzić, czy takie usuwanie wystarczy - usuwanie z ekstensji
    public void usunKsiegowa(){
        ksiegowa = null;
    }

    public void usunFirma(){
        firma = null;
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (HashMap<String, Faktura>) stream.readObject();
    }

    public static Map<String, Faktura> getEkstensja(){
        return ekstensja;
    }

    // gettery i settery
    public Ksiegowa getKsiegowa() {
        return ksiegowa;
    }

    public Firma getFirma(){
        return firma;
    }

    public String getNumer(){
        return numer;
    }

    public BigDecimal getNetto(){
        BigDecimal netto = new BigDecimal(0);
        for (Pozycja pozycja : pozycje) {
            pozycja.getNetto();
            netto = netto.add(pozycja.getNetto());
        }
        return netto;
    }

    public BigDecimal getBrutto(){
        BigDecimal brutto = new BigDecimal(0);
        for (Pozycja pozycja : pozycje) {
            pozycja.getNetto();
            brutto = brutto.add(pozycja.getBrutto());
        }
        return brutto;
    }

    public Firma getWystawca(){
        return wystawca;
    }
    public void addPozycja(Pozycja pozycja){
        pozycje.add(pozycja);
    }

    public void usunPozycja(Pozycja pozycja){
        if(pozycje.contains(pozycja)){
            pozycje.remove(pozycja);
        }
    }

    @Override
    public String toString() {
        return numer;
    }
}
