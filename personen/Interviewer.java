/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package personen;

import data.Vraag;

public class Interviewer extends Persoon implements InterviewerInterface, BodeInterface {
    private String omroep;
    private String beroep = "Interviewer";

    @Override
    public String StelMoeilijkeVraag() {
        return Vraag.getVraag();
    }

    @Override
    public String getOmroep() {
        return this.omroep;
    }

    @Override
    public void setOmroep(String omroep) {
        this.omroep = omroep;
    }

    @Override
    /**
     * Ga briefjes rondbrengen
     *
     *
     */

    public void brengBriefjesRond() {
        System.out.println("Hallo mijn naam is " + getNaam() + " Mijn beroep is " + getBeroep() + " Ik breng vandaag briefjes rond");
        System.out.println("Mag ik U interviewen als ik hiermee klaar ben ?");
    }

    @Override
    /**
     * Ga koffie verzorgen
     *
     *
     */
    public void verzorgKoffie() {
        System.out.println("Hallo ik ben " + getNaam() + "Mijn beroep is " + beroep + "Er zijn vandaag geen bodes, dus ik verzorg de Koffie, wie wil wwn bakkie /");
    }

    @Override
    public String getBeroep() {
        return beroep;
    }
}
