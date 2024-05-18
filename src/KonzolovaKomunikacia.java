import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class KonzolovaKomunikacia {

    private Scanner skener;

    public KonzolovaKomunikacia() {

        this.skener = new Scanner(System.in);
    }

    public ArrayList<String> getMenaHracov(int pocetHracov) {
        ArrayList<String> zoznamMien = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println("Napis svoje meno");
            zoznamMien.add(this.skener.nextLine());
        }
        return zoznamMien;
    }

    public void vypisBalicek(Balicek balicek) {
        System.out.println("Balicek");
        System.out.println("V balicku ostava:" + balicek.getPocetZostavajucichKariet() + "kariet");
        System.out.println("Posledna polozena karta je: " + balicek.poslednePouzitaKarta());
    }

    public void vypisKartyHracov(List<Hrac> hraci, int indexHracaNaRade) {
        System.out.println("Hraci: ");
        for (int i = 0; i < hraci.size(); i++) {
            if (i != indexHracaNaRade) {
                ArrayList<Karta> kartyHraca = hraci.get(i).getKartyNaRuke();
                System.out.println("Hrac: " + hraci.get(i).getMeno());
                System.out.println("Karty:");
                for (int j = 0; j < kartyHraca.size(); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        System.out.println("Hrac: " + hraci.get(indexHracaNaRade).getMeno());
        System.out.println("karty: ");
        ArrayList<Karta> kartyHracaNaRuke = hraci.get(indexHracaNaRade).getKartyNaRuke();
        for (int i = 0; i < kartyHracaNaRuke.size(); i++) {
            Karta aktualnaKarta = kartyHracaNaRuke.get(i);
            System.out.print(" " + (i + 1) + ". " + aktualnaKarta);
        }
        System.out.println();
    }

    public boolean chceSiHracPotiahnutKartu() {
        System.out.println("Chces si potiahnut kartu a - ano / n - nie");

        while (true) {
            String vystup = this.skener.nextLine().toLowerCase();
            if (vystup.equals("a")) {
                return true;
            }
            if (vystup.equals("n")) {
                return false;
            } else {
                System.out.println("Prosim zadaj a alebo n");
            }
        }
    }

    public int vyberKartuHraca(List<Hrac> hraci, int indexHracaNaRade) {
        ArrayList<Karta>kartyHracaNaRade = hraci.get(indexHracaNaRade).getKartyNaRuke();
        System.out.println("Vyber si kartu, ktoru chces zahrat (1,2,3...)");
        return this.vyberMoznosti(kartyHracaNaRade.size() );
    }

    public Farba vyberFarbu() {
        System.out.println("Vyber si novu farbu");
        for (int i = 0; i < Farba.values().length - 1; i++) {
            System.out.print((i + 1) + ". " + Farba.values()[i].name() + " ");
        }
        return Farba.values()[this.vyberMoznosti(Farba.values().length - 1) - 1 ];
    }

    public void vypisChybuPriPokladani(String chyba) {
        System.out.println(chyba);
    }

    public void vypisUpozorneniaOPriebehuHry(String upozornenie) {
        System.out.println(upozornenie);
    }

    private int vyberMoznosti(int maxVyber) {
        int volba = 0;
        boolean jeVstupOK = false;

        while (!jeVstupOK) {
            String input = this.skener.nextLine();

            try {
                volba = Integer.parseInt(input);
                if (1 <= volba && volba <= maxVyber) {
                    jeVstupOK = true;
                } else {
                    System.out.println("Prosim zadaj cislo v rozsahu");
                }
            } catch (NumberFormatException e) {
                System.out.println("Zly vstup musis zadat cislo");
            }
        }
        return volba;
    }
}
