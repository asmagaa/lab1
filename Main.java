import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // klient.txt
        String[] imiona = {"Amir\t", "Haj\t", "Napleton\t", "Tymon\t", "Jaroslaw\t", "Tomasz\t", "Krzysztof\t", "Walenty\t"};
        String[] nazwiska = {"Swiech\t", "Ahmad\t", "Sigmaga\t", "Kutasinski\t", "Kaczynski\t", "Problem\t", "Kocurek\t", "Sawko\t"};

        // cena.txt
        String[] ceny = {"377\t", "610\t", "987\t", "1597\t", "2584\t", "4181\t", "6765\t", "10946\t", "17711\t", "28657\t", "46368\t", "75025\t"};

        // rodzaj_projektu.txt
        String[] rodzajProjektu = {"Podstawowy projekt programistyczny\t", "Sredni projekt programistyczny\t", "Wysoki projekt programistyczny\t", "Projekt programistyczny pro+ subskrypcja\t"};

        // dostawcy.txt
        String[] dostawcy = {"Niggerman\t", "Harnas&Romper\t", "DHL\t", "Poczta Polska\t"};

        Random rand = new Random();
        try {
            FileWriter rodzajProjektuWriter = new FileWriter("rodzaj_projektu.txt");
            FileWriter cenaWriter = new FileWriter("cena.txt");
            FileWriter klientWriter = new FileWriter("klient.txt");
            FileWriter dostawcyWriter = new FileWriter("dostawcy.txt");
            FileWriter rekordyWriter = new FileWriter("rekordy.txt");

            // zapytania do sql
            System.out.println("INSERT INTO projekty (klient_id, dostawcy_id, rodzaj_projektu_id, cena_id) VALUES");
            for (int i = 1; i <= 1000; i++) {
                System.out.printf("(%d, %d, %d, %d),%n", i, i, i, i);
            }

            // Generacja
            for (int i = 0; i < 1000; i++) {
                // cena.txt
                cenaWriter.write("\t" + ceny[rand.nextInt(ceny.length)] + "\n");

                // klient.txt
                klientWriter.write("\t" + imiona[rand.nextInt(imiona.length)] + nazwiska[rand.nextInt(nazwiska.length)] + "\n");

                // dostawcy.txt
                dostawcyWriter.write("\t" + dostawcy[rand.nextInt(dostawcy.length)] + "\n");

                // rodzaj_projektu.txt
                rodzajProjektuWriter.write("\t" + rodzajProjektu[rand.nextInt(rodzajProjektu.length)] + "\n");
            }

            rodzajProjektuWriter.close();
            cenaWriter.close();
            klientWriter.close();
            dostawcyWriter.close();
            rekordyWriter.close();
            System.out.println("Wygenerowane sigma");

        } catch (IOException e) {
            System.out.println("Aha ( " + e.getMessage() + " )");
        }
    }
}