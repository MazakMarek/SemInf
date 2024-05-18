public class KartaZmenSmer extends AkcnaKarta {

    private Hra hra;
    private Balicek balicek;

    public KartaZmenSmer(Farba farba, Hra hra, Balicek balicek) {
        super(farba, Hodnota.AKCNA, hra, balicek);
        this.hra = hra;
    }

    @Override
    public void hraj() {
        this.hra.zmenSmer();
        Hrac hracCoPojde = this.hra.getDalsiHrac();
        this.hra.getKonzolovaKomunikacia().vypisUpozorneniaOPriebehuHry("Bola pouzita karta zmen smer, na rade je hrac" + hracCoPojde.getMeno());
    }

    @Override
    public boolean mozemPolozit() {

        return this.balicek.poslednePouzitaKarta().getFarba() == this.getFarba() ||
                this.balicek.poslednePouzitaKarta() instanceof KartaZmenSmer;
    }

    @Override
    public String toString() {

        return super.toString() + " zmen smer " + super.getFarba();
    }
}