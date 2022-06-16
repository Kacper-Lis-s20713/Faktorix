package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pracownik implements Serializable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private double premia = 0;
    private Firma firma;

    private static List<Pracownik> ekstensja = new ArrayList<>();
    private List<Umowa> umowy = new ArrayList<>();
    private static Set<Umowa> wszystkieUmowy = new HashSet<>();

    public Pracownik(String imie, String nazwisko, String pesel, double premia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.premia = premia;
    }

    public Pracownik(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    //Asocjacja Pracownik 0..1---1 [numer pracownika]Firma (asocjacja z kwalifikatorem)
    public void ustawFirme(Firma nowaFirma) throws Exception {
        if(firma != null){
            firma.usunPracownika(this);
        }
        firma = nowaFirma;
        firma.dodajPracownika(this);
    }

    public void usunFirme() {
        this.firma = null;
    }

    //Asocjacja Pracownik ◆1---* Umowa (Kompozycja)
    public void dodajUmowe(Umowa umowa) throws Exception {
        if(!umowy.contains(umowa)){
            if(wszystkieUmowy.contains(umowa)){
                throw new Exception("Ta umowa jest już dodana do jakiegoś pracownika");
            }
            umowy.add(umowa);
            wszystkieUmowy.add(umowa);
        }
    }

    public void usunUmowe(Umowa umowa){
        umowa.usunPracownika();
        umowy.remove(umowa);
        wszystkieUmowy.remove(umowa);
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (List<Pracownik>) stream.readObject();
    }

    public static List<Pracownik> getEkstensja(){
        return ekstensja;
    }

    // gettery i settery

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    // TO-DO zarządzanie premią, nie może być mniejsza niż zero
    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }

    public void addPremia(double premia){
        this.premia += premia;
    }
}
