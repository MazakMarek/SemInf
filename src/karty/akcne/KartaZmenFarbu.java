package karty.akcne;

import hra.Balicek;
import hra.Hra;
import karty.Farba;
import karty.Hodnota;

public class KartaZmenFarbu extends AkcnaKarta {

    public KartaZmenFarbu(Hra hra, Balicek balicek) {

        super(Farba.ZIADNA, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {

        this.setFarbu(super.getHra().getKonzolovaKomunikacia().vyberFarbu());
    }

    @Override
    public boolean mozemPolozit() {

        return super.mozemPolozit();
    }

    @Override
    public String toString() {
        String vystup = super.toString() + " Zmen farbu ";
        if (super.getFarba() != Farba.ZIADNA) {
            vystup += super.getFarba();
        }
        return vystup;
    }
}