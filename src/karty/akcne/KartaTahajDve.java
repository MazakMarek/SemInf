package karty.akcne;

import hra.Balicek;
import hra.Hra;
import karty.Farba;
import karty.Hodnota;

public class KartaTahajDve extends AkcnaKarta {

    public KartaTahajDve(Farba farba, Hra hra, Balicek balicek) {

        super(farba, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        super.getHra().tahaj(super.getHra().getDalsiHrac(), 2);
        super.getHra().posunPoradieDopredu(1);
    }

    @Override
    public boolean mozemPolozit() {
        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba() ||
                super.getBalicek().poslednePouzitaKarta() instanceof KartaTahajDve;
    }

    @Override
    public String toString() {

        return super.toString() + " tahaj dve " + super.getFarba();
    }
}