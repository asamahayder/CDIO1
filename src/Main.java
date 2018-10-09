import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Denne boolean bliver senere brugt til at skifte tur mellem de 2 spillere.
        //Hvis Spillertur = true -> Spiller 1 & Spillertur = false -> Spiller 2.
        boolean Spillertur = true;

        //Sætter de point som en af spillerne skal have for at vinde
        int finalpoint = 39;

        System.out.println("Indtast navn på spiller 1");
        String spiller1 = scan.nextLine();

        System.out.println("Indtast navn på spiller 2");
        String spiller2 = scan.nextLine();

        Spiller s1 = new Spiller(spiller1);
        Spiller s2 = new Spiller(spiller2);

        System.out.println("Spiller 1: " + s1.fåNavn());
        System.out.println("Spiller 2: " + s2.fåNavn());

        //Opretter 2 nye terning objekter vi bruger til vores "Terning.kast" klasse der laver matematikken
        Terning terning1 = new Terning();
        Terning terning2 = new Terning();

        //Starter et while loop der fortæller mens mindst en af spillernes samlede point er under "finalpoint" skal den køre dette loop
        while (s1.fåPoint() <= finalpoint && s2.fåPoint() <= finalpoint) {

            //Laver funktionen der fortæller brugeren at de skal indtaste værdien "kast" for at fortsætte for enten den ene eller anden spiller
            if (Spillertur == true) {
                System.out.println("Det er nu " + s1.fåNavn() + "'s tur til at kaste terningen. Tast" + " \"kast\" " + "for at fortsætte spillet.");

            } else if (Spillertur == false) {
                System.out.println("Det nu " + s2.fåNavn() + "'s tur til at kaste terningen. Tast" + " \"kast\" " + "for at fortsætte spillet.");
            }

            //Sætter en scanner der skal læse næste linje skrevet af brugeren for at fortsætte
            String request = scan.next();

            //Siger hvis den indtastede værdi var kast skal den køre de 2 terning objekter og beregne matematikken for at simulere en terning
            if (request.equalsIgnoreCase("kast")) {
                terning1.kast();
                terning2.kast();

                //Lægger de 2 terning værdier sammen og henter dem fra vores Terning klasse
                int sum = terning1.fåØjne() + terning2.fåØjne();

                //Metoden for hvis en af spillerne slår 2 1'ere og de taber deres score
                if (terning1.fåØjne() == 1 && terning1.fåØjne() == terning2.fåØjne() && Spillertur == true) {
                    System.out.println(s1.fåNavn() + " slog et par " + terning1.fåØjne() + "'ere & har nu tabt sin score men får en ny tur");
                    s1.genstartScore();

                } else if (terning1.fåØjne() == 1 && terning1.fåØjne() == terning2.fåØjne() && Spillertur == false) {
                    System.out.println(s2.fåNavn() + " slog et par " + terning1.fåØjne() + "'ere & har nu tabt sin score men får en ny tur");
                    s2.genstartScore();

                } else {

                    //tilføjer de nye ternings point til spiller 1's score
                    if (Spillertur == true && terning1.fåØjne() != terning2.fåØjne()) {
                        System.out.println(s1.fåNavn() + " slog en " + terning1.fåØjne() + "'er" + " & en " + terning2.fåØjne() + "'er og får den samlede sum " + sum);
                        s1.tilføjPoint(sum);
                        Spillertur = false;

                        //Medtoden for hvis spiller 1 slår et par og giver ham en ekstra tur.
                    } else if (Spillertur == true && terning1.fåØjne() == terning2.fåØjne()) {
                        System.out.println(s1.fåNavn() + " slog et par " + terning1.fåØjne() + "'ere & får den samlede sum " + sum + " og får en ny tur");
                        s1.tilføjPoint(sum);
                        s1.brugsidstePoint(sum);
                        Spillertur = true;

                        //Tilføjer de nye ternings point til spiller 2's score
                    } else if (Spillertur == false && terning1.fåØjne() != terning2.fåØjne()) {
                        System.out.println(s2.fåNavn() + " slog en " + terning1.fåØjne() + "'er" + " & en " + terning2.fåØjne() + "'er og får den samlede sum " + sum + " og får en ny tur");
                        s2.tilføjPoint(sum);
                        Spillertur = true;

                        //Medtoden for hvis spiller 2 slår et par og giver ham en ekstra tur
                    } else if (Spillertur == false && terning1.fåØjne() == terning2.fåØjne()) {
                        System.out.println(s2.fåNavn() + " slog et par " + terning1.fåØjne() + "'ere & får en samlede sum " + sum);
                        s2.tilføjPoint(sum);
                        s2.brugsidstePoint(sum);
                        Spillertur = false;
                    }
                }
                //Fortæller stilling mellem de 2 spillere.
                System.out.println("Det står nu " + s1.fåPoint() + " point til " + s1.fåNavn() + " & " + s2.fåPoint() + " point til " + s2.fåNavn());
            }
        }
        //Fortæller hvis en af spillerne har fået over 'finalpoint' vinder spilleren og spillet slutter
        if (s1.fåPoint() >= finalpoint) {

            System.out.println(s1.fåNavn() + " har fået en total score over 40 point og har derfor vundet spillet");

        } else if (s2.fåPoint() >= finalpoint) {

            System.out.println(s2.fåNavn() + " har fået en total score over 40 point og har derfor vundet spiller");
        }
        scan.close();
    }
}