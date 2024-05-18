import java.util.ArrayList;

public class Hrac {
    private final String meno;
    private ArrayList<Karta> kartyNaRuke;

    public Hrac(String meno) {
        this.meno = meno;
        this.kartyNaRuke = new ArrayList<>();
    }

    // vrati meno hraca
    public String getMeno() {

        return this.meno;
    }

    //vrati karty ktore ma hrac an ruke
    public ArrayList<Karta> getKartyNaRuke() {

        return this.kartyNaRuke;
    }

    // prida hracovi kartu do ruky
    public void tahajKartu(Karta karta) {

        this.kartyNaRuke.add(karta);
    }

    // metoda na pouzitie karty z ruky
    public Karta zahrajKartu(int indexKarty) {
        this.kartyNaRuke.get(indexKarty).hraj();
        return this.kartyNaRuke.remove(indexKarty);
    }

    //vrati pocet kariet na ruke
    public int pocetKartietNaRuke() {

        return this.kartyNaRuke.size();
    }

}