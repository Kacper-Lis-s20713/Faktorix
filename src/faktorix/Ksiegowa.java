package faktorix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ksiegowa extends Osoba{
    public enum RodzajKsiegowej{
        ZWYKLA, KADROWA;
    }

    private List<RodzajKsiegowej> rodzajKsiegowej; //TO-DO: [1..2] co najmniej jeden rodzaj księgowej [zwykla, zwykla-kadrowa, kadrowa]
    private List<Faktura> faktury = new ArrayList<>();
    private List<ObslugaFirmy> obslugiFirmy = new ArrayList<>();

    public Ksiegowa(String login, String haslo, List<RodzajKsiegowej> rodzajKsiegowej) {
        super(login, haslo);
        this.rodzajKsiegowej = rodzajKsiegowej;
    }

    public void addFaktura(Faktura nowafaktura){
        if(!faktury.contains(nowafaktura)){
            faktury.add(nowafaktura);
            // Polaczenie zwrotne
            if(!this.equals(nowafaktura.getKsiegowa())){
                nowafaktura.setKsiegowa(this);
            }
        }
    }
    public void usunFakture(Faktura faktura) {
        if(faktury.contains(faktura)){
            faktury.remove(faktura);
            faktura.usunKsiegowa();
        }
    }

    // Asocjacja Ksiegowa 1---* ObslugaFirmy
    public void addObslugaFirmy(ObslugaFirmy nowaObslugaFirmy) {
        if(!obslugiFirmy.contains(nowaObslugaFirmy)){
            obslugiFirmy.add(nowaObslugaFirmy);
            if(!this.equals(nowaObslugaFirmy.getKsiegowa())){
                nowaObslugaFirmy.setKsiegowa(this);
            }
        }
    }

    public void usunObslugaFirmy(ObslugaFirmy obslugaFirmy) {
        if(obslugiFirmy.contains(obslugaFirmy)){
            obslugiFirmy.remove(obslugaFirmy);
            obslugaFirmy.usunPolaczenie();
        }
    }

    public List<ObslugaFirmy> getObslugiFirmy() {
        return obslugiFirmy;
    }

    public List<Faktura> getFaktury() {
        return faktury;
    }

    @Override
    public String toString() {
        return this.getLogin();
    }

    // Tutaj dużo method (biznesowych)
}
