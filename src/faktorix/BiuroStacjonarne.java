package faktorix;

import java.io.Serializable;

public class BiuroStacjonarne extends Biuro implements Serializable {
    private int iloscStanowisk;

    public BiuroStacjonarne(String adres, String nazwa, int iloscStanowisk) {
        super(adres, nazwa);
        this.iloscStanowisk = iloscStanowisk;
    }
}
