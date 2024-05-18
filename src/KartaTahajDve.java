public class KartaTahajDve extends AkcnaKarta {

    private Hra hra;
    private Balicek balicek;
    public KartaTahajDve(Farba farba, Hra hra, Balicek  balicek) {

        super(farba, Hodnota.AKCNA, hra, balicek);
    }

    @Override
    public void hraj() {
        this.hra.tahaj(this.hra.getDalsiHrac(),2);
        this.hra.posunPoradieDopredu(1);
    }

    @Override
    public boolean mozemPolozit() {
        return this.balicek.poslednePouzitaKarta().getFarba() == this.getFarba() ||
                this.balicek.poslednePouzitaKarta() instanceof KartaTahajDve;
    }

    @Override
    public String toString() {

        return super.toString() + " tahaj dve " + super.getFarba();
    }
}