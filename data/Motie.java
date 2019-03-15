/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package data;


public class Motie {
    public static int NUMBER_OF_TYPES = 4;
    ;

    public String nieuwMotie(Type soort) {
        String rv = "\nGehoord hebbende de beraadslaging, stellen wij het volgende voor:\n";
        switch (soort) {
            case SOCIAAL:
                rv = socialeMotie();
                break;
            case LIBERAAL:
                rv = liberaleMotie();
                break;
            case LANDBOUW:
                rv = landbouwMotie();
                break;
            case INFRA:
                rv = wegenbouwMotie();
                break;
        }

        rv += "\nEn gaan over tot de orde van de dag\n\n";
        return rv;
    }

    private String socialeMotie() {
        return "Wij vinden dat er geld gestopt moet worden in sociale woningen, goede thuiszorg voor iedereen en goede bereikbaarheid via openbaar vervoer.";
    }

    private String liberaleMotie() {
        return "Wij vinden dat iedereen voor zichzelf moet zorgen en dat bedrijven geen strobreed in de weg gelegd mag worden om hun geld te verdienen en door te sluizen naar belastingparadijzen.";
    }

    private String landbouwMotie() {
        return "Wij vinden dat boeren moeten worden ondersteund in een transitie naar duurzaamheid met respect voor natuur en mileu.";

    }

    private String wegenbouwMotie() {
        return "Wij vinden dat er meer wegen gebouwd moeten worden en meer bruggen en waterwegen en dat soort werk.";
    }

    public static enum Type {SOCIAAL, LIBERAAL, LANDBOUW, INFRA}


}
