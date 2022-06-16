package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObslugaFirmy implements Serializable {
    private LocalDateTime rozpoczeciePracy;
    private LocalDateTime zakonczeniePracy;

    private Ksiegowa ksiegowa;
    private Firma firma;

    private static List<ObslugaFirmy> ekstensja = new ArrayList<>();

    public ObslugaFirmy(LocalDateTime rozpoczeciePracy, LocalDateTime zakonczeniePracy, Ksiegowa ksiegowa, Firma firma){
        this.rozpoczeciePracy = rozpoczeciePracy;
        this.zakonczeniePracy = zakonczeniePracy;
        this.ksiegowa = ksiegowa;
        this.firma = firma;
        ekstensja.add(this);
        ksiegowa.addObslugaFirmy(this);
        firma.addObslugaFirmy(this);
    }

    // Asocjacja ObslugaFirmy *---1 Firma
    public void setFirma(Firma nowafirma) {
        if(firma != null){
            firma.usunObslugaFirmy(this);
        }
        firma = nowafirma;
        firma.addObslugaFirmy(this);
    }

    // Asocjacja ObslugaFirmy *---1 Ksiegowa
    public void setKsiegowa(Ksiegowa nowaKsiegowa) {
        if(ksiegowa != null){
            ksiegowa.usunObslugaFirmy(this);
        }
        ksiegowa = nowaKsiegowa;
        ksiegowa.addObslugaFirmy(this);
    }

    // Asocjacja Firma 1---* ObslugaFirmy *---1 Ksiegowa
    // Uniwersalne usunięcie połączenia
    public void usunPolaczenie(){
        if(this.firma != null){
            this.firma.usunObslugaFirmy(this);
        }
        this.firma = null;
        if(this.ksiegowa != null) {
            this.ksiegowa.usunObslugaFirmy(this);
        }
        this.ksiegowa = null;
        this.usunZEkstensji(this);
    }

    // gettery i settery

    public Firma getFirma() {
        return firma;
    }

    public Ksiegowa getKsiegowa() {
        return ksiegowa;
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (List<ObslugaFirmy>) stream.readObject();
    }

    public static List<ObslugaFirmy> getEkstensja() {
        return ekstensja;
    }

    public void usunZEkstensji(ObslugaFirmy obslugaFirmy){
        ekstensja.remove(obslugaFirmy);
    }

    @Override
    public String toString() {
        return "ObslugaFirmy{" +
                "rozpoczeciePracy=" + rozpoczeciePracy +
                ", zakonczeniePracy=" + zakonczeniePracy +
                ", ksiegowa=" + ksiegowa +
                ", firma=" + firma +
                '}';
    }
}
