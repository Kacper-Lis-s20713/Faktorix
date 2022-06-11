package faktorix;

import java.io.Serializable;
import java.util.List;

public class Faktura implements Serializable {
    public enum MetodaPlatnosci{
        KARTA, GOTOWKA, PRZELEW;
    }
    private String numer; //{unique}
    private MetodaPlatnosci metodaPlatnosci;

}
