/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package runner;

import java.util.*;
import java.util.Scanner;

import personen.Interviewer;
import personen.Persoon;
import personen.TweedeKamerlid;
import personen.Bode;
import data.Data;
import personen.BodeInterface;
import commissies.*;
import audio.*;

public class TweedeKamer {
    private static Random rnd = new Random();
    MusicPlayer speel = new MusicPlayer();
    private ArrayList<ArrayList<Persoon>> personen;

    public TweedeKamer() {
        System.out.println("Welkom in de Tweede Kamer.");
        System.out.println("Hieronder staande mogelijke activiteiten:");

        boolean loop = true;
        Scanner reader = new Scanner(System.in);
        while (loop) {
            toonKeuzeMenu();
            String input = reader.next();

            switch (input) {
                case "0":
                    System.out.println("Graag tot een volgende keer.");
                    speel.startPlaying("../tweedekamer final/audio/Teksten/TotZiens.mp3");
                    loop = false;
                    break;
                case "1":
                    debateer();
                    break;
                case "2":
                    interview();
                    break;
                case "3":
                    toonMensenInHetGebouw();
                    break;
                case "4":
                    haalKoffie();
                    break;
                case "5":
                    brengBriefjesRond();
                    break;
                case "6":
                    maakWillekeurigeCommissie();
                    break;
                case "7":
                    printActieveCommissies();
                    break;
                case "8":
                    toonInfoCommissie();
                    break;
                case "9":
                    hefCommissieOp();
                    break;
                case "10":
                    speelBoodschap();
                    break;
                case "11":
                    wijzigVoorzitter();
                    break;
                default:
                    System.out.println("Onbekende input");
                    toonKeuzeMenu();
            }

        }
        reader.close();
    }

    private void debateer() {
        int i = 0;
        TweedeKamerlid k;
        while (++i < 20) {
            k = Data.getRandomPoliticus();
            System.out.print("(Lid " + k.getNaam() + "): ");
            System.out.println(k.reageer());
        }
    }

    private void haalKoffie() {

        Data.getRandomBode().verzorgKoffie();

    }

    private void brengBriefjesRond() {
        int geselecteerd = rnd.nextInt(Data.getBriefjesRondbrenger().size()); // kies een willekeurige Briefjesrondbrenger
        Data.getBriefjesRondbrenger().get(geselecteerd).brengBriefjesRond();
    }

    private void interview() {
        Interviewer interviewer = Data.getRandomInterviewer();
        TweedeKamerlid politicus = Data.getRandomPoliticus();

        System.out.println("Goedemiddag, " + interviewer.getNaam()
                + " hier, voor de omroep " + interviewer.getOmroep());
        System.out.print("We spreken vandaag met " + politicus.getNaam());
        System.out.println("(geboren op " + politicus.getGeboortedatum() + ")");
        System.out.println("Die is lid van de tweede kamer voor " + politicus.getpartij());

        int i = 0;
        while (i++ < 20) {
            System.out.println(i);
            System.out.println("V: " + interviewer.StelMoeilijkeVraag());
            System.out.println("A: " + politicus.reageer());
        }
    }

    private void toonMensenInHetGebouw() {
        System.out.println("Momenteel bevinden zich de volgende personen in het gebouw:");

        // TEST: welke optimalisatie zien we in de loop hier beneden (hint: memory leak)?
        for (ArrayList<? extends Persoon> lijst : Data.getPersonen()) {
            for (Persoon p : lijst) {
                String aanhef = p.getGender() == 'M' ? "De heer " : "Mevrouw ";
                System.out.print(aanhef + p.getNaam());
                System.out.println(", geboren " + p.getGeboortedatum());
            }
        }
    }

    private void toonKeuzeMenu() {
        System.out.println("\n\n ");
        System.out.println("  0. beeindig Uw bezoek.");
        System.out.println("  1. volg een debat.");
        System.out.println("  2. bekijk een interview.");
        System.out.println("  3. kijk wie er allemaal in het gebouw zijn.");
        System.out.println("  4. Haal koffie.");
        System.out.println("  5. Breng briefjes rond.");
        System.out.println("  6. Selecteer een willekeurige commissie,");
        System.out.println("       kies het aantal leden en kies de voorzitter.");
        System.out.println("  7. Laat alle actieve commissies zien.");
        System.out.println("  8. Toon informatie over een actieve commissie.");
        System.out.println("  9. Hef een commissie op.");
        System.out.println(" 10. Roep een mededeling.");
        System.out.println(" 11. Pas de voorzitter van een actieve commissie aan.");
        System.out.println("Typ uw keuze:");
    }

    /**
     * Controleer of er nog niet actieve commissies zijn, zoja:
     * Selecteer een willekeurige commisie, en controleer of deze nog niet actief is, anders kies een nieuwe
     * <p>
     * Vraag om het aantal leden voor de betreffende commissie (min 1 max het aantal kamerleden)
     * stel de commissie willekeurig samen met het aantal opgegeven leden
     * controleer op dubbeling
     * <p>
     * Vul de gevonden niet actieve commissie met de met geselecteerd leden
     * Voeg de commissie toe aan de lijst met actieve commissies
     */
    private void maakWillekeurigeCommissie() {

        boolean dubbel;
        ArrayList<TweedeKamerlid> commissieleden = new ArrayList();
        if (Data.getActieveCommissies().size() >= Data.getCommissie().size())      // controleer of er nog niet actieve commissies zijn
        {
            System.out.println("Alle " + Data.getCommissie().size() + " beschikbare commissies zijn actief");       // alle commisies zijn actief
        } else {
            CommissieAlgemeen nieuweCommissie = null;
            boolean gevonden = false;
            while (!gevonden)   // zoek een commissie die nog niet actief is
            {
                nieuweCommissie = Data.getRandomCommisssie();   // selecteer willekeurig een commissie
                boolean komtvoor = false;

                for (CommissieAlgemeen commissie : Data.getActieveCommissies())   // Controleer of commissie al actief is
                {

                    if (commissie.getNaamCommisie().equals(nieuweCommissie.getNaamCommisie())) {
                        komtvoor = true;
                    }

                }
                if (!komtvoor) {
                    gevonden = true;
                }
            }
            // vraag naar het aantal leden
            System.out.println("Uit hoeveel leden bestaat de ");
            System.out.println("   " + nieuweCommissie.getNaamCommisie());
            System.out.println("          (Min 1, Max " + Data.getKamerleden().size() + ")");
            System.out.println("Typ uw keuze:");
            int aantalLeden = bepaalKeuze(1, Data.getKamerleden().size());


            // Vul de commissie willekeurig met het gekozen aantal leden
            commissieleden.add(Data.getRandomPoliticus());      //eerste commissielid

            while (aantalLeden > commissieleden.size()) {
                dubbel = false;

                TweedeKamerlid volgende = Data.getRandomPoliticus();
                for (TweedeKamerlid commissielid : commissieleden)      // controleren of naam al in de commissie zit
                {
                    if (commissielid.getNaam().equals(volgende.getNaam())) {
                        dubbel = true;
                    }
                }
                if (!dubbel) {
                    commissieleden.add(volgende);
                }     // er is geen dubbele gevonden, dus voeg lid toe
            }


            nieuweCommissie.setCommissieLeden(commissieleden);      //voeg de geselecteerde leden toe aan de commisiie
            Data.getActieveCommissies().add(nieuweCommissie); // voeg de commissie toe aan de lijst actieve commissies

            kiesVoorzitter(nieuweCommissie);

        }

    }

    /**
     * Toon info over alle actieve commissies
     */
    private void printActieveCommissies() {
        System.out.println();
        if (Data.getActieveCommissies().size() == 0) {
            System.out.println("Er zijn geen actieve commissies.");
        } else {
            System.out.println("Overzicht actieve commissies:");
            System.out.println();
            for (CommissieAlgemeen actief : Data.getActieveCommissies()) {
                actief.printCommissieInfo();

            }
        }
    }

    /**
     * Toon een lijst van alle actieve commissies
     * Bied mogelijk om een actieve commissie te kiezen
     * Hef de gekozen commissie op
     */
    private void hefCommissieOp() {
        int keuze = selecteerCommissie("Welke commissie wilt U opheffen ?");
        boolean loop = true;
        if (keuze > 0) {
            Data.getActieveCommissies().get(keuze - 1).printCommissieInfo();
            System.out.println();
            System.out.println("         WORDT OPGEHEVEN !!");
            System.out.println("         Weet U het zeker ?? ja/nee ");
            System.out.println("Typ uw keuze:");

            while (loop) {
                Scanner reader = new Scanner(System.in);
                String input = reader.next();
                switch (input) {
                    case "ja":
                        System.out.println(Data.getActieveCommissies().get(keuze - 1).getNaamCommisie() + "  IS OPGEHEVEN !!!");
                        loop = false;
                        Data.getActieveCommissies().remove(keuze - 1);
                        break; //  verwijder de commissie
                    case "nee":
                        System.out.println("Geen commissie verwijderd. ");
                        loop = false;
                        break;
                    default:
                        System.out.println("foutieve keuze");
                        break;

                }

            }
        }

    }

    /**
     * Toon een lijst van alle actieve commissies
     * Bied mogelijk om een actieve commissie te kiezen
     * Toon de leden van de gekozen commissie op
     */
    private void toonInfoCommissie() {
        int keuze = selecteerCommissie("Over welke commissie wilt informatie ?");
        if (keuze > 0) {
            System.out.println("De opgevraagde informatie:");
            Data.getActieveCommissies().get(keuze - 1).printCommissieInfo();// toon de informatie
        }

    }

    /**
     * Toon actieve commissies en laat er een kiezen
     * Toon de leden van de gekozen commissie
     * Geef de mogelijkheid een voorzitter te kiezen uit de leden
     * Pas de voorzitter aan
     */
    private void wijzigVoorzitter() {
        int commissieKeuze = selecteerCommissie("Van welke commissie wilt de voorzitter kiezen/aanpassen ?");
        if (commissieKeuze > 0) {
            kiesVoorzitter(Data.getActieveCommissies().get(commissieKeuze - 1));

        }
    }

    /**
     * Toon de leden van de gekozen commissie
     * Geef de mogelijkheid een voorzitter te kiezen uit de leden
     * Pas de voorzitter aan
     */
    private void kiesVoorzitter(CommissieAlgemeen commissie) {
        int teller = 1;

        // Bouw het startscherm op en vraag om een keuze
        System.out.println("Naam van de commissie : " + commissie.getNaamCommisie());
        if (commissie.getVoorzitter().getNaam() == null) {
            System.out.println("Huidige voorzitter is niet benoemd");
        } else {
            System.out.println("Huidige voorzitter is " + commissie.getVoorzitter().getNaam());
        }

        System.out.println("Kies een voorzitter : ");
        System.out.println("   " + "0 Geen voorzitter");
        for (TweedeKamerlid lid : commissie.getCommissieLeden()) {
            System.out.println("   " + teller + " " + lid.getNaam());
            teller = teller + 1;
        }
        System.out.println("   " + (commissie.getCommissieLeden().size() + 1) + " Geen wijziging");
        System.out.println("Typ uw keuze:");

        //Bepaal de keuze
        int voorzitterKeuze = bepaalKeuze(0, commissie.getCommissieLeden().size() + 1);


        // voer de acties die bij de keuze horen uit
        if (voorzitterKeuze > 0) {

            if (voorzitterKeuze < commissie.getCommissieLeden().size() + 1) {
                System.out.println("De voorzitter is gewijzigd");// pas de voorzitter aan
                commissie.setVoorzitter((commissie.getCommissieLeden().get(voorzitterKeuze - 1)));

            } else {
                System.out.println("Er is niets gewijzigd");
            }
        } else {
            System.out.println("Commissie heeft geen voorzitter");
            commissie.maakVoorzitterLeeg();
        }
        commissie.printCommissieInfo(); // toon de informatie
    }

    /**
     * Toon een lijst van alle actieve commissies
     * Bied mogelijk om een actieve commissie te kiezen
     * controleer op juistheid keuze
     *
     * @return het keuzenummer van de gekozen commissie, of  0 als geen commissie gekozen wordt (keuze 0)
     */
    private int selecteerCommissie(String hoofdKeuze) {
        int commissieKeuze = 0;
        if (Data.getActieveCommissies().isEmpty()) {
            System.out.println("Er zijn geen actieve commissies.");
        }// controleer of er actieve commissies zijn
        else {// Bouw het scherm op en vraag een keuze
            System.out.println(hoofdKeuze);
            System.out.println();
            System.out.println("       " + 0 + " : " + "Geen commissie");
            int positie = 1;
            for (CommissieAlgemeen commissie : Data.getActieveCommissies())// toon welke commissies actief zijn
            {
                System.out.println("       " + positie + " : " + commissie.getNaamCommisie());
                positie = positie + 1;
            }
            System.out.println("Typ uw keuze:");

            commissieKeuze = bepaalKeuze(0, Data.getActieveCommissies().size());

        }
        return commissieKeuze;

    }

    /**
     * Kies een random mededeling en speel hem af
     */
    private void speelBoodschap() {
        int mededeling = rnd.nextInt(speel.getNumberOfFiles());
        speel.startPlaying(mededeling);
    }

    /**
     * Haal input op
     * Controleer of ingegeven waarde nummeriek is
     * Controleer of de input binnen de opgegeven min en max ligt
     * Geef de keuze als int terug
     */
    private int bepaalKeuze(int min, int max) {
        boolean loop = true;
        int keuze = 0;
        while (loop) {
            Scanner reader = new Scanner(System.in);

            //controleer of de input nummeriek is
            if (!reader.hasNextInt()) {
                System.out.println("Geen geldige keuze.");
            } else {
                keuze = reader.nextInt();
                // controleer of het ingegeven aantal binnen de grenzen ligt
                if (keuze < min || keuze > max) {
                    System.out.println("Geen geldige keuze");
                } else {
                    loop = false;
                }

            }


        }
        return keuze;
    }


}

