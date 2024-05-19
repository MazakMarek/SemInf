package karty;

import hra.Balicek;
import hra.Hra;

public abstract class Karta {
    private Hra hra;
    private Balicek balicek;
    private Farba farba;
    private final Hodnota hodnota;

    public Karta(Farba farba, Hodnota hodnota, Hra hra, Balicek balicek) {
        this.farba = farba;
        this.hodnota = hodnota;
        this.hra = hra;
        this.balicek = balicek;
    }

    public Farba getFarba() {

        return this.farba;
    }

    public Hodnota getHodnota() {

        return this.hodnota;
    }

    // metoda na ziskanie hodnoty karty v stringu
    @Override
    public String toString() {
        if (this.hodnota == Hodnota.AKCNA) {
            return "Akcna karta ";
        } else {
            return this.hodnota.getValue().toString();
        }
    }

    public abstract boolean mozemPolozit();

    // implementacia polymorfizmu, kazda akcna karta inak implementuje tuto metodu
    public abstract void hraj();

    public void setFarbu(Farba novaFarba) {

        this.farba = novaFarba;
    }

    public Hra getHra() {
        return this.hra;
    }

    public Balicek getBalicek() {
        return this.balicek;
    }
}