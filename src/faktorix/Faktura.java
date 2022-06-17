package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Faktura implements Serializable {
    public enum MetodaPlatnosci{
        KARTA, GOTOWKA, PRZELEW;
    }

    private String numer; //{unique} TODO
    private MetodaPlatnosci metodaPlatnosci;

    // Połączenia asocjacji
    private Ksiegowa ksiegowa; // Nie ustawiam null, ponieważ zakładam, że faktura nie może powstać bez księgowej
    private Firma firma;

    // Ekstensja Klasy
    private static Map<String, Faktura> ekstensja = new HashMap<>();

    public Faktura(String numer, MetodaPlatnosci metodaPlatnosci, Ksiegowa ksiegowa, Firma firma) {
        this.numer = numer;
        this.metodaPlatnosci = metodaPlatnosci;
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

    public Ksiegowa getKsiegowa() {
        return ksiegowa;
    }

    public Firma getFirma(){
        return firma;
    }

    @Override
    public String toString() {
        return numer;
    }
}
