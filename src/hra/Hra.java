package hra;

import ui.KonzolovaKomunikacia;

import java.util.ArrayList;
import java.util.List;

public class Hra {
    private List<Hrac> hraci;
    private Balicek balicek;

    private final KonzolovaKomunikacia konzolovaKomunikacia;

    private boolean smerDopredu = true;

    private boolean jeKoniec = false;
    private static final int POCETKARIETNAZACIATKU = 7;
    private int hracNaRade;

    public Hra(int pocetHracov) {
        this.hraci = new ArrayList<>();
        this.balicek = new Balicek(this);
        this.hracNaRade = 0;

        this.konzolovaKomunikacia = new KonzolovaKomunikacia();

        this.balicek.rozmiesajKarty();
        this.balicek.pripravPrvuKartu();
        this.inicializujHracov(pocetHracov);
        this.rozdelKarty();

    }

    public void gameLoop() {
        while (!this.jeKoniec) {
            boolean chybaPriHre = true;
            Hrac hracNaTahu = null;

            while (chybaPriHre) {
                hracNaTahu = this.hraci.get(this.hracNaRade);
                this.konzolovaKomunikacia.vypisBalicek(this.balicek);
                this.konzolovaKomunikacia.vypisKartyHracov(this.hraci, this.hracNaRade);
                if (this.konzolovaKomunikacia.chceSiHracPotiahnutKartu()) {
                    this.tahaj(hracNaTahu, 1);
                    this.posunPoradieDopredu(1);
                    continue;
                }
                int indexVybratejKarty = this.konzolovaKomunikacia.vyberKartuHraca(this.hraci, this.hracNaRade) - 1;
                if (hracNaTahu.getKartyNaRuke().get(indexVybratejKarty).mozemPolozit()) {
                    this.balicek.pridajKartuDoKopy(hracNaTahu.zahrajKartu(indexVybratejKarty));
                    chybaPriHre = false;
                } else {
                    this.konzolovaKomunikacia.vypisChybuPriPokladani("karty.Karta sa neda polozit");
                }
            }
            this.posunPoradieDopredu(1);
            this.hracVyhral(hracNaTahu);
            //TODO upravit aby to mazalo obrazovku po tahu
            this.clearScreen();
        }
    }

    private void inicializujHracov(int pocetHracov) {
        ArrayList<String> menaHracov = this.konzolovaKomunikacia.getMenaHracov(pocetHracov);
        for (String meno: menaHracov) {
            this.hraci.add(new Hrac(meno));
        }
    }


    //rozdeli karty na zaciatku hry
    private void rozdelKarty() {
        for (Hrac hrac : this.hraci) {
            for (int i = 0; i < POCETKARIETNAZACIATKU; i++) {
                hrac.tahajKartu(this.balicek.potiahniKartu());
            }
        }
    }

    public void zmenSmer() {

        this.smerDopredu = !this.smerDopredu;
    }

    public Hrac getDalsiHrac() {

        if (this.smerDopredu) {
            return this.hraci.get((this.hracNaRade + 1) % this.hraci.size());
        } else {
            return this.hraci.get((this.hracNaRade - 1) % this.hraci.size());
        }
    }

    public void tahaj(Hrac hrac, int pocetKariet) {
        for (int i = 0; i < pocetKariet; i++) {
            hrac.tahajKartu(this.balicek.potiahniKartu());
        }
    }

    public void posunPoradieDopredu(int pocetHracov) {
        if (this.smerDopredu) {
            this.hracNaRade = (this.hracNaRade + pocetHracov) % this.hraci.size();
        } else {
            this.hracNaRade = (this.hracNaRade - pocetHracov) % this.hraci.size();
        }

    }

    private void hracVyhral(Hrac hrac) {
        if (hrac.pocetKartietNaRuke() == 0) {
            this.jeKoniec = !this.jeKoniec;
        }
    }

    public KonzolovaKomunikacia getKonzolovaKomunikacia() {
        return this.konzolovaKomunikacia;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}