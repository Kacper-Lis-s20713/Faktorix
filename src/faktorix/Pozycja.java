package faktorix;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pozycja implements Serializable {
    private String nazwa;
    private double stawkaVAT;
    private BigDecimal netto;
    private BigDecimal brutto;

    public Pozycja(String nazwa, double stawkaVAT, BigDecimal netto) {
        this.nazwa = nazwa;
        this.stawkaVAT = stawkaVAT;
        this.netto = netto;
        this.brutto = netto.multiply(new BigDecimal(1.0 + stawkaVAT));
    }

//    public void wyliczNetto(){
//        BigDecimal vat = new BigDecimal(1.0+stawkaVAT);
//        netto = brutto.divide(vat);
//    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getStawkaVAT() {
        return stawkaVAT;
    }

    public void setStawkaVAT(double stawkaVAT) {
        this.stawkaVAT = stawkaVAT;
    }

    public BigDecimal getNetto() {
        return netto;
    }

    public void setNetto(BigDecimal netto) {
        this.netto = netto;
    }

    public BigDecimal getBrutto() {
        return brutto;
    }

    public void setBrutto(BigDecimal brutto) {
        this.brutto = brutto;
    }
}
