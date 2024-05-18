package karty.akcne;

import hra.Balicek;
import hra.Hra;
import hra.Hrac;
import karty.Farba;
import karty.Hodnota;

public class KartaZmenSmer extends AkcnaKarta {

    public KartaZmenSmer(Farba farba, Hra hra, Balicek balicek) {

        super(farba, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        super.getHra().zmenSmer();
        Hrac hracCoPojde = super.getHra().getDalsiHrac();
        super.getHra().getKonzolovaKomunikacia().vypisUpozorneniaOPriebehuHry("Bola pouzita karta zmen smer, na rade je hrac" + hracCoPojde.getMeno());
    }

    @Override
    public boolean mozemPolozit() {

        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba() ||
                super.getBalicek().poslednePouzitaKarta() instanceof KartaZmenSmer;
    }

    @Override
    public String toString() {

        return super.toString() + " zmen smer " + super.getFarba();
    }
}