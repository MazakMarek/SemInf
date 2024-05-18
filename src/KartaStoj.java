public class KartaStoj extends AkcnaKarta {

    private Hra hra;
    private Balicek balicek;

    public KartaStoj(Farba farba, Hra hra, Balicek  balicek) {
        super(farba, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        Hrac hracCoStoji = this.hra.getDalsiHrac();
        this.hra.posunPoradieDopredu(1);
        this.hra.getKonzolovaKomunikacia().vypisUpozorneniaOPriebehuHry("Bola pouzita karta statia, hrac menom " + hracCoStoji.getMeno() + " stoji");
    }

    @Override
    public boolean mozemPolozit() {

        return this.balicek.poslednePouzitaKarta().getFarba() == this.getFarba() ||
                this.balicek.poslednePouzitaKarta() instanceof KartaStoj;
    }

    @Override
    public String toString() {

        return super.toString() + " Stoj " + super.getFarba();
    }
}