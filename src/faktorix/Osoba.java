package faktorix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Osoba implements Serializable {
    private String login; //{Unique} TO-DO
    private String haslo;

    private static Map<String, Osoba> ekstensja = new HashMap<>();

    public Osoba(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
        ekstensja.put(login, this);
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensja = (HashMap<String, Osoba>) stream.readObject();
    }

    public static Map<String, Osoba> getEkstensja(){
        return ekstensja;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }
}
