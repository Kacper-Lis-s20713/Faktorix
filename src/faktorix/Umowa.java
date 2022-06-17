package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Umowa implements Serializable {
    private LocalDate dataZatrudnienia;
    private LocalDate dataZakonczenia; // Może być null, trzeba o tym pamiętać przy implementacji niektórych metod
    private BigDecimal pensja;

    private static List<Umowa> ekstensja = new ArrayList<>();
    private Pracownik pracownik;

    private Umowa(Pracownik pracownik, LocalDate dataZatrudnienia, LocalDate dataZakonczenia, BigDecimal pensja) {
        this.pracownik = pracownik;
        this.dataZatrudnienia = dataZatrudnienia;
        this.dataZakonczenia = dataZakonczenia;
        this.pensja = pensja;
        ekstensja.add(this);
    }

    // Asocjacja Umowa *---1◆ Pracownik
    // Tą asocjacją zarządzamy z klasy całości (Pracownik)
    public static Umowa utworzUmowa(Pracownik pracownik, LocalDate dataZatrudnienia, LocalDate dataZakonczenia, BigDecimal pensja) throws Exception{
        if(pracownik == null){
            throw new Exception("Taki urzytkownik nie istnieje");
        }

        Umowa umowa = new Umowa(pracownik, dataZatrudnienia, dataZakonczenia, pensja);
        pracownik.dodajUmowe(umowa);

        return umowa;
    }

    // TODO zastanowić się czy usuwanie tylko z poziomu klasy Pracownik to dobre rozwiązanie
    public void usunPracownika(){
        this.pracownik = null;
        ekstensja.remove(this);
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (List<Umowa>) stream.readObject();
    }

    public static List<Umowa> getEkstensja(){
        return ekstensja;
    }
}
