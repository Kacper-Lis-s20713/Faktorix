package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Osoba implements Serializable {
    private String login; //{Unique} TODO
    private String haslo;
    private Biuro biuro;
    private static Map<String, Osoba> ekstensja = new HashMap<>();
    private static Set<RolaSystemowa> wszystkieRole = new HashSet<>();
    private RolaSystemowa rolaSystemowa;

    public Osoba(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
        ekstensja.put(login, this);
    }

    // TODO sprawdzić czy nie będzie problemu przez brak sprawdzenia czy jest już ustawiona jakaś rola
    // Asocjacja Osoba ◆1---1 Rola Systemowa
    public void setRolaSystemowa(RolaSystemowa rolaSystemowa) throws Exception{
        if(wszystkieRole.contains(rolaSystemowa)){
            throw new Exception("Ta rola jest już przypisana do jakiegoś pracownika");
        }
        this.rolaSystemowa = rolaSystemowa;
        wszystkieRole.add(rolaSystemowa);
    }

    public void usunRola(RolaSystemowa rolaSystemowa){
        rolaSystemowa.usunOsoba();
        this.rolaSystemowa = null;
        wszystkieRole.remove(rolaSystemowa);

    }

    // Asocjacja Osoba *--{XOR}--0..1 Biuro <---- stacjonarne i zdalne
    public void setBiuro(Biuro noweBiuro){
        if(biuro != null){
            biuro.usunOsoba(this);
        }
        biuro = noweBiuro;
        biuro.dodajOsoba(this);
    }

    public void usunBiuro(){
        this.biuro = null;
    }

    // Zarządzanie ekstensją
    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (HashMap<String, Osoba>) stream.readObject();
    }

    public static Map<String, Osoba> getEkstensja(){
        return ekstensja;
    }

    // gettery i settery
    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public Biuro getBiuro() {
        return biuro;
    }
}
