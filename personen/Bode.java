/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package personen;

import java.util.*;

/**
 * class Bode - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Bode extends Persoon implements BodeInterface {
    private static Random rnd = new Random();
    // instance variables
    private String hoofdDeksel;
    private String beroep;

    /**
     * Constructor voor objects van class Bode
     */
    public Bode() {
        beroep = "Bode";
    }

    //@Override

    /**
     * Ga briefjes rondbrengen
     */

    public void brengBriefjesRond() {
        System.out.println("Hallo mijn naam is " + getNaam() + " Mijn beroep is " + getBeroep() + " Ik breng vandaag briefjes rond");
        System.out.println("U kijkt misschien vreemd naar mijn " + getHoofdBedekking());
    }

    @Override
    /**
     * Ga koffie verzorgen
     *
     *
     */
    public void verzorgKoffie() {
        System.out.println("Hallo ik ben " + getNaam() + " Wie wil er Koffie ?");
        System.out.println("En wat vinden jullie van mijn " + getHoofdBedekking());
    }

    /**
     * Kies een hoofbedekking
     */
    public void kiesHoofdBedekking() {
        int getal = rnd.nextInt(6);
        switch (getal) {
            case 0:
                hoofdDeksel = "Pruik";
                break;
            case 1:
                hoofdDeksel = "Hoed";
                break;
            case 2:
                hoofdDeksel = "Muts";
                break;
            case 3:
                hoofdDeksel = "Pet";
                break;
            case 4:
                hoofdDeksel = "Toupet";
                break;
            default:
                hoofdDeksel = "Kale hoofd";
        }
    }

    /**
     * Haal de hoofdbedekking op.
     *
     * @return: hoofbedekking
     */

    public String getHoofdBedekking() {
        return hoofdDeksel;
    }

    @Override
    public String getBeroep() {
        return beroep;
    }
}
