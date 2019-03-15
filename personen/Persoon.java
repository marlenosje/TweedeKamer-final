/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package personen;

public abstract class Persoon {
    private String naam;
    private String geboortedatum;
    private char gender;

    public String getGeboortedatum() {
        return this.geboortedatum;
    }

    public void setGeboortedatum(String value) {
        this.geboortedatum = value;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String value) {
        this.naam = value;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char value) {
        this.gender = value;
    }
}

