package karty.akcne;

import hra.Balicek;
import hra.Hra;
import karty.Karta;
import karty.Farba;
import karty.Hodnota;

public abstract class AkcnaKarta extends Karta {

    public AkcnaKarta(Farba farba, Hodnota hodnota, Hra hra, Balicek balicek) {

        super(farba, hodnota, hra, balicek);
    }
}