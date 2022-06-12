package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Firma implements Serializable {

    public enum RodzajFirmy{
        PARTNERSKA, KOMANDYTOWA, KOMANDYTOWOAKCYJNA, ZOO, PROSTAAKCYJNA, AKCYJNA, DZIALALNOSC, CYWILNA, JAWNA;
    }

    private RodzajFirmy rodzajFirmy;
    private DaneFirmy daneFirmy;
    private String numerRachunku;

    private static List<Firma> ekstensja = new ArrayList<>();

    private List<Faktura> faktury = new ArrayList<>();

    public Firma(RodzajFirmy rodzajFirmy, DaneFirmy daneFirmy, String numerRachunku) {
        this.rodzajFirmy = rodzajFirmy;
        this.daneFirmy = daneFirmy;
        this.numerRachunku = numerRachunku;
        ekstensja.add(this);
    }

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
            faktura.usunKsiegowa();
        }
    }

    public List<Faktura> getFaktury() {
        return faktury;
    }

    public DaneFirmy getDaneFirmy() {
        return daneFirmy;
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (ArrayList<Firma>) stream.readObject();
    }

    public static List<Firma> getEkstensja() {
        return ekstensja;
    }

    @Override
    public String toString() {
        return daneFirmy.getNazwaFirmy();
    }
}
