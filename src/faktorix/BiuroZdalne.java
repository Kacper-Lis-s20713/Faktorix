package faktorix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BiuroZdalne extends Biuro implements Serializable {
    public enum SytemOperacyjny{
        MACOS, WINDOWS, LINUX;
    }
    private List<SytemOperacyjny> sytemyOperacyjne = new ArrayList<>();

    public BiuroZdalne(String adres, String nazwa, List<SytemOperacyjny> sytemyOperacyjne) {
        super(adres, nazwa);
        this.sytemyOperacyjne = sytemyOperacyjne;
    }

}
