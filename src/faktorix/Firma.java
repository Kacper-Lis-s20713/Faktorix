package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Firma implements Serializable {
    public enum RodzajFirmy{
        PARTNERSKA, KOMANDYTOWA, KOMANDYTOWOAKCYJNA, ZOO, PROSTAAKCYJNA, AKCYJNA, DZIALALNOSC, CYWILNA, JAWNA;
    }

    private RodzajFirmy rodzajFirmy;
    private DaneFirmy daneFirmy;
    private String numerRachunku;

    private static List<Firma> ekstensja = new ArrayList<>();

    private List<Faktura> faktury = new ArrayList<>();
    private List<ObslugaFirmy> obslugiFirmy = new ArrayList<>();
    private Map<String, Pracownik> pracownicy = new TreeMap<>();

    public Firma(RodzajFirmy rodzajFirmy, DaneFirmy daneFirmy, String numerRachunku) {
        this.rodzajFirmy = rodzajFirmy;
        this.daneFirmy = daneFirmy;
        this.numerRachunku = numerRachunku;
        ekstensja.add(this);
    }

    //Asocjacja Firma 1---* ObslugaFirmy
    public void addObslugaFirmy(ObslugaFirmy nowaObslugaFirmy) {
        if(!obslugiFirmy.contains(nowaObslugaFirmy)){
            obslugiFirmy.add(nowaObslugaFirmy);
            if(!this.equals(nowaObslugaFirmy.getFirma())){
                nowaObslugaFirmy.setFirma(this);
            }
        }
    }

    public void usunObslugaFirmy(ObslugaFirmy obslugaFirmy){
        if(obslugiFirmy.contains(obslugaFirmy)){
            obslugiFirmy.remove(obslugaFirmy);
            obslugaFirmy.usunPolaczenie();
        }
    }


    // Asocjacja Firma 1---* Faktura
    public void addFaktura(Faktura nowaFaktura){
        if(!faktury.contains(nowaFaktura)){
            faktury.add(nowaFaktura);
            if(!this.equals(nowaFaktura.getFirma())){
                nowaFaktura.setFirma(this);
            }
        }
    }
    public void usunFakture(Faktura faktura) {
        if(faktury.contains(faktura)){
            faktury.remove(faktura);
            faktura.usunFirma();
        }
    }

    // Asocjacja Firma[numer pracownika] 1---0..1 Pracownik (asocjacja z kwalifikatorem)
    public void dodajPracownika(Pracownik pracownik) throws Exception{
        if(!pracownicy.containsKey(pracownik.getPesel())){
            pracownicy.put(pracownik.getPesel(), pracownik);
            pracownik.ustawFirme(this);
        }
    }

    public void usunPracownika(Pracownik pracownik) {
        if(pracownicy.containsKey(pracownik.getPesel())){
            pracownicy.remove(pracownik.getPesel());
        }
        pracownik.usunFirme();
    }

    public Pracownik znajdzPracownika(String pesel) throws Exception{
        if (pracownicy.containsKey(pesel)) {
            return pracownicy.get(pesel);
        }
        throw new Exception("Nie ma pracownika o peselu: " + pesel);
    }

    // gettery i settery
    public List<Faktura> getFaktury() {
        return faktury;
    }

    public DaneFirmy getDaneFirmy() {
        return daneFirmy;
    }
    public List<ObslugaFirmy> getObslugiFirmy() {
        return obslugiFirmy;
    }

    // Obsługa ekstensji
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (ArrayList<Firma>) stream.readObject();
    }

    public static List<Firma> getEkstensja() {
        return ekstensja;
    }

    // To string
    @Override
    public String toString() {
        return daneFirmy.getNazwaFirmy();
    }
}
