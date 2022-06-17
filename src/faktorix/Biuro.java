package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Biuro implements Serializable {
    private String adres;
    private String nazwa;

    private static List<Biuro> ekstensja = new ArrayList<>();
    private List<Osoba> osoby = new ArrayList<>();

    public Biuro(String adres, String nazwa) {
        this.adres = adres;
        this.nazwa = nazwa;
        ekstensja.add(this);
    }
    // Asocjacja Osoba *--{XOR}--0..1 Biuro <---- stacjonarne i zdalne
    public void dodajOsoba(Osoba nowaOsoba){
        if(!osoby.contains(nowaOsoba)){
            osoby.add(nowaOsoba);
            if(!this.equals(nowaOsoba.getBiuro())){
                nowaOsoba.setBiuro(this);
            }
        }
    }

    public void usunOsoba(Osoba osoba) {
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (ArrayList<Biuro>) stream.readObject();
    }

    public static List<Biuro> getEkstensja() {
        return ekstensja;
    }
    // gettery i settery


    public String getAdres() {
        return adres;
    }
}
