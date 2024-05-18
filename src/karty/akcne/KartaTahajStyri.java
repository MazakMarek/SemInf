package karty.akcne;

import hra.Balicek;
import hra.Hra;
import karty.Farba;
import karty.Hodnota;

public class KartaTahajStyri extends AkcnaKarta {

    public KartaTahajStyri(Hra hra, Balicek balicek) {

        super(Farba.ZIADNA, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        super.getHra().tahaj(super.getHra().getDalsiHrac(), 4);
        this.setFarbu(super.getHra().getKonzolovaKomunikacia().vyberFarbu());
        super.getHra().posunPoradieDopredu(1);
    }

    @Override
    public boolean mozemPolozit() {

        return super.mozemPolozit();
    }

    @Override
    public String toString() {

        return super.toString() + " Tahaj styri";
    }
}