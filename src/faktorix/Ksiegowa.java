package faktorix;

import java.io.Serializable;
import java.util.List;

public class Ksiegowa extends Osoba{
    public enum RodzajKsiegowej{
        ZWYKLA, KADROWA;
    }

    private List<RodzajKsiegowej> rodzajKsiegowej;

    public Ksiegowa(String login, String haslo, List<RodzajKsiegowej> rodzajKsiegowej) {
        super(login, haslo);
        this.rodzajKsiegowej = rodzajKsiegowej;
    }

    // Tutaj dużo method (biznesowych)
}
