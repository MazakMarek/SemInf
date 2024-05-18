public class AkcnaKarta extends Karta {

    public AkcnaKarta(Farba farba, Hodnota hodnota, Hra hra, Balicek balicek) {

        super(farba, hodnota, hra, balicek);
    }

    @Override
    public void hraj() {
    }

    @Override
    public boolean mozemPolozit() {

        return super.getBalicek().poslednePouzitaKarta().getFarba() == this.getFarba();
    }
}