/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package commissies;

import java.util.*;

import personen.*;

/**
 * class CommissieAlgemeen
 *
 * @author Paul Tonk
 * @version feb 2019
 */
public abstract class CommissieAlgemeen {
    private String naamCommissie;
    private String oprichtingsDatum;
    private ArrayList<TweedeKamerlid> commissieLeden;
    private TweedeKamerlid Voorzitter = new TweedeKamerlid();


    public void setNaamCommissie(String value) {
        this.naamCommissie = value;
    }

    public String getNaamCommisie() {
        return naamCommissie;
    }

    public String getOprichtingsDatum() {
        return oprichtingsDatum;
    }

    public void setOprichtingsDatum(String value) {
        this.oprichtingsDatum = value;
    }

    public ArrayList<TweedeKamerlid> getCommissieLeden() {
        return commissieLeden;
    }

    public void setCommissieLeden(ArrayList<TweedeKamerlid> commissieleden) {
        this.commissieLeden = commissieleden;
    }

    public Persoon getVoorzitter() {
        return Voorzitter;
    }

    public void setVoorzitter(TweedeKamerlid value) {
        this.Voorzitter = value;
    }

    public void maakVoorzitterLeeg() {
        Voorzitter = new TweedeKamerlid();
    }

    public void printCommissieInfo() {
        System.out.println();
        System.out.println("                     " + getNaamCommisie());
        System.out.println("Gevormd op " + getOprichtingsDatum());

        System.out.println("Leden (" + commissieLeden.size() + "): ");
        for (TweedeKamerlid commissielid : commissieLeden) {
            String sexe = "onbekend";
            switch (commissielid.getGender()) {
                case 'M':
                    sexe = "man";
                    break;
                case 'V':
                    sexe = "vrouw";
                    break;
                default:
                    sexe = "onbekend";
                    break;
            }
            System.out.println("   " + commissielid.getNaam() + "(" + sexe + ", " + commissielid.getpartij() + ")");

        }
        if (Voorzitter.getNaam() == null) {
            System.out.println("De voorzitter is niet benoemd ");
        } else {
            System.out.println("De voorzitter is " + Voorzitter.getNaam());
        }
    }

}
