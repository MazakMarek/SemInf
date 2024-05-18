public class KartaZmenFarbu extends AkcnaKarta {

    private Hra hra;
    private Balicek balicek;
    public KartaZmenFarbu(Hra hra, Balicek balicek) {

        super(Farba.ZIADNA, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {

        this.setFarbu(this.hra.getKonzolovaKomunikacia().vyberFarbu());
    }

    @Override
    public boolean mozemPolozit() {

        return true;
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