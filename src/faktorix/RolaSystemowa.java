package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RolaSystemowa implements Serializable {
    public enum Rola{
        ZWYKLY, ADMIN;
    }
    private Rola rola;
    private LocalDate dataUtworzenia;

    private static List<RolaSystemowa> ekstensja = new ArrayList<>();
    private Osoba osoba;

    private RolaSystemowa(Osoba osoba, Rola rola) {
        this.rola = rola;
        this.osoba = osoba;
        this.dataUtworzenia = LocalDate.now();
    }

    // Asocjacja Osoba ◆1---1 Rola Systemowa
    public static RolaSystemowa utworzRolaSystemowa(Osoba osoba, Rola rola) throws Exception{
        RolaSystemowa rolaSystemowa = new RolaSystemowa(osoba, rola);
        osoba.setRolaSystemowa(rolaSystemowa);
        return rolaSystemowa;
    }

    public void usunOsoba(){
        this.osoba = null;
        ekstensja.remove(this);
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (ArrayList<RolaSystemowa>) stream.readObject();
    }

    public static List<RolaSystemowa> getEkstensja() {
        return ekstensja;
    }

    // gettery i settery


}
