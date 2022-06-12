package faktorix;

import java.io.Serializable;

public class DaneFirmy implements Serializable {
    private String NIP;
    private String nazwaFirmy;
    private String adres;

    public DaneFirmy(String NIP, String nazwaFirmy, String adres) {
        this.NIP = NIP;
        this.nazwaFirmy = nazwaFirmy;
        this.adres = adres;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
