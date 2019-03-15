/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package personen;

import java.util.Random;

import data.Motie;
import data.Motie.Type;
import data.Uitspraak;

public class TweedeKamerlid extends Persoon implements Politicus {
    String beroep = "Politicus";
    private String partij;
    private Random rnd = new Random();

    /*
     * Methodes uit de interface Politicus
     */

    @Override
    public String reageer() {
        return Uitspraak.getUitspraak();
    }

    @Override
    public Motie schrijfMotie() {
        Motie rv = new Motie();
        int r = rnd.nextInt(Motie.NUMBER_OF_TYPES);
        Type t = Type.INFRA;

        switch (r) {
            case (0):
                t = Type.INFRA;
                break;
            case (1):
                t = Type.LANDBOUW;
                break;
            case (2):
                t = Type.LIBERAAL;
                break;
            case (3):
                t = Type.SOCIAAL;
                break;
        }

        rv.nieuwMotie(t);

        return rv;
    }

    @Override
    public String definieerBudget(String doel) {
        int money = rnd.nextInt(100000);
        return "Budget voor " + doel + ": " + money;
    }

    @Override
    public String getpartij() {
        return this.partij;
    }

    @Override
    public void setPartij(String value) {
        this.partij = value;
    }


}
