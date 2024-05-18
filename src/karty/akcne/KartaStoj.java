package karty.akcne;

import hra.Balicek;
import hra.Hra;
import hra.Hrac;
import karty.Farba;
import karty.Hodnota;

public class KartaStoj extends AkcnaKarta {

    public KartaStoj(Farba farba, Hra hra, Balicek balicek) {
        super(farba, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        Hrac hracCoStoji = super.getHra().getDalsiHrac();
        super.getHra().posunPoradieDopredu(1);
        super.getHra().getKonzolovaKomunikacia().vypisUpozorneniaOPriebehuHry("Bola pouzita karta statia, hrac menom " + hracCoStoji.getMeno() + " stoji");
    }

    @Override
    public boolean mozemPolozit() {

        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba() ||
                super.getBalicek().poslednePouzitaKarta() instanceof KartaStoj;
    }

    @Override
    public String toString() {

        return super.toString() + " Stoj " + super.getFarba();
    }
}