package karty.normalne;

import hra.Balicek;
import hra.Hra;
import karty.Farba;
import karty.Hodnota;
import karty.Karta;

public class KartaCisel extends Karta {



    public KartaCisel(Farba farba, Hodnota hodnota, Hra hra, Balicek balicek) {
        super(farba, hodnota, hra, balicek);

    }

    @Override
    public void hraj() {

        System.out.println("bola zahrata: " + this);
    }

    @Override
    public boolean mozemPolozit() {
        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba() ||
                (super.getBalicek().poslednePouzitaKarta().getHodnota() == this.getHodnota() ||
                        (super.getBalicek().poslednePouzitaKarta().getHodnota() == Hodnota.AKCNA &&
                                super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba()));
    }

    @Override
    public String toString() {

        return super.toString() + " " + super.getFarba();
    }
}