import Domein.ElektrischeFiets;

import java.util.Scanner;

public class FietsApp {
    public static void main(String[] args) {
        new FietsApp().start();
    }

    Scanner invoer = new Scanner(System.in);

    private void start() {
        int aantalDeelnemers = 0;
        int vermogen;
        int maxSnelheid;
        int deelnemer = 1;
        int helmRijbewijs = 0;
        double totaal = 0;
        int laagsteSnelheid = 0;


        vermogen = leesVermogenIn(deelnemer);
        while (vermogen != 0) {
            maxSnelheid = leesMaxSnelheidIn();
            ElektrischeFiets eF = new ElektrischeFiets(maxSnelheid,vermogen);

            if (laagsteSnelheid == 0) {
                laagsteSnelheid = eF.getMaxSnelheid();
            } else if (maxSnelheid < laagsteSnelheid) {
                laagsteSnelheid = eF.getMaxSnelheid();
            }
            System.out.printf("Fietser rijdt met een'%s'\n", eF.toString());

            if (eF.isGemotoriseerdeFiets() || eF.isSpeedpedelec()) {
                System.out.print("--> fietser moet minstens 16 jaar oud zijn!\n");
            }

            if (eF.isSpeedpedelec()) {
                System.out.print("--> fietser moet helm dragen en rijbewijs hebben!\n");
                helmRijbewijs++;
            }

            System.out.print("\n");

            deelnemer++;
            aantalDeelnemers++;
            if (helmRijbewijs != 0)
                totaal = (double) helmRijbewijs / aantalDeelnemers * 100;
            vermogen = leesVermogenIn(deelnemer);


        }
        if (deelnemer > 1) {
            System.out.printf("Er %s %d deelnemer%s.\n", aantalDeelnemers == 1 ? "is" : "zijn", aantalDeelnemers, aantalDeelnemers == 1 ? "" : "s");
            System.out.printf("%.2f%% van de deelnemers moet verplicht een helm dragen en een rijbewijs hebben!\n", totaal);
            System.out.printf("Aanbevloen tempo voor de tocht is %d km/uur.", laagsteSnelheid);

        }


    }

    public int leesVermogenIn(int deelnemer) {
        int vermogen;
        boolean nietGeldig;
        do {

            System.out.printf("Welk vermogen heeft de fiets van deelnemer %d (0 om te stoppen)? ", deelnemer);
            vermogen = invoer.nextInt();
            if (vermogen == 0) {
                System.out.println("Geen enthousiaste fietsers vandaag...\n");
                break;
            }
            nietGeldig = vermogen < 100 || vermogen > 4000;
            if (nietGeldig) {
                System.out.println("Het vermogen moet tussen 100 en 4000 liggen, probeer opnieuw...");
            }
        } while (nietGeldig);
        return vermogen;
    }

    public int leesMaxSnelheidIn() {
        int maxSnelheid;

        System.out.printf("Geef maximale snelheid van de fiets > ? ");
        maxSnelheid = invoer.nextInt();
        return maxSnelheid;
    }


}

