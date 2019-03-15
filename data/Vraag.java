/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package data;

import java.util.Random;

public class Vraag {

    private static String[] vragen = {
            "Als u opnieuw zou moeten kiezen, welke opleiding zou u dan volgen?",
            "Hoe bent u op deze positie terecht gekomen?",
            "Biedt deze positie u de mogelijkheid uw ambities waar te maken?",
            "Vind u de afdrachtregeling echt zo'n goed idee?",
            "Waarom moet Schiphol zo nodig uitbreiden via Lelystad?",
            "Vind u dat u voldoende betaald krijgt voor het werk dat u doet?",
            "Wat is er eigenlijk leuk aan politicus zijn?",
            "Waar moet ik heen?",
            "Ziet u mogelijkheden deze coalitie nog vlot te trekken?",
            "Wat vind u van de stille machtsovername van Marijnisse bij de SP?",
            "Welke reden is er als u geen zin heeft om naar uw werk te gaan?",
            "Wat zijn de belangrijke persoonlijke eigenschappen die je in dit werk goed kunt gebruiken?"
    };

    private static Random rnd = new Random();

    public static String getVraag() {
        int foo = rnd.nextInt(vragen.length);
        return vragen[foo];
    }
}
