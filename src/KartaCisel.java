public class KartaCisel extends Karta {

    private Hra hra;
    private Balicek balicek;

    public KartaCisel(Farba farba, Hodnota hodnota, Hra hra, Balicek balicek) {
        super(farba, hodnota, hra, balicek);
        this.balicek = balicek;
    }

    @Override
    public void hraj() {

        System.out.println("bola zahrata: " + this);
    }

    //TODO skontrolovat logiku nie osm si isty s tretou podmienkou
    @Override
    public boolean mozemPolozit() {
        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba() ||
                (this.balicek.poslednePouzitaKarta().getHodnota() == this.getHodnota() ||
                        this.balicek.poslednePouzitaKarta().getHodnota() == Hodnota.AKCNA);
    }

    @Override
    public String toString() {

        return super.toString() + " " + super.getFarba();
    }
}