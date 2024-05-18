import java.util.ArrayList;
import java.util.Collections;

public class Balicek {
    private final Hra hra;
    private ArrayList<Karta> pouziteKarty;
    private ArrayList<Karta> karty;

    public Balicek(Hra hra) {
        this.hra = hra;
        this.karty = new ArrayList<>();
        this.pouziteKarty = new ArrayList<>();
        this.inicializujBalicek();
    }

    //vytvorenie balicka so spravnym poctom kariet
    private void inicializujBalicek() {
        //inicializacia vsetkych kariet od 1-9 vo vsetkych farbach tie su v balicku 2x
        for (Farba farba : Farba.values()) {
            if (farba == Farba.ZIADNA) {
                continue;
            }
            for (int hodnota = 1; hodnota <= 9; hodnota++) {
                this.karty.add(new KartaCisel(farba, Hodnota.values()[hodnota], this.hra , this));
                this.karty.add(new KartaCisel(farba, Hodnota.values()[hodnota], this.hra , this));
            }
            // vytvorenie karty s hodnotou 0(je iba jedna v balicku pre kazdy farbu)
            this.karty.add(new KartaCisel(farba, Hodnota.NULA, this.hra, this ));
            // vytvorenie akcnych kariet kt maju farbu
            for (int i = 0; i < 2; i++) {
                this.karty.add(new KartaStoj(farba, this.hra, this));
                this.karty.add(new KartaZmenSmer(farba, this.hra, this));
                this.karty.add(new KartaTahajDve(farba, this.hra, this));
            }
        }
        //vytvori akcne karty kt nemaju farbu
        for (int i = 0; i < 4; i++) {
            this.karty.add(new KartaZmenFarbu(this.hra, this));
            this.karty.add(new KartaTahajStyri(this.hra, this));
        }
    }

    // pripravy prvu kartu hry tak aby nebola akcna
    public void pripravPrvuKartu() {
        Karta pouzitaKarta;
        do {
            pouzitaKarta = this.potiahniKartu();
        } while (!(pouzitaKarta instanceof KartaCisel));
        this.pouziteKarty.add(pouzitaKarta);
    }

    // rozmiesa karty
    public void rozmiesajKarty() {
        Collections.shuffle(this.karty);
    }

    // zoberie kartu z balicka
    public Karta potiahniKartu() {
        return this.karty.remove(0);
    }

    // ukaze poslednu hranu kartu
    public Karta poslednePouzitaKarta() {

        return this.pouziteKarty.get(this.pouziteKarty.size() - 1);
    }

    // prida kartu do kopy na "stole"
    public void pridajKartuDoKopy(Karta karta) {

        this.pouziteKarty.add(karta);
    }

    // vrati pocet kariet v balicku
    public int getPocetZostavajucichKariet() {
        return this.karty.size();
    }
}