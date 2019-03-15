/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package data;

import java.util.Random;


public class Uitspraak {
    private static String[] uitspraken = {
            "Pleur op.",
            "Doe zelf effe lekker normaal.",
            "Doe eens normaal man.",
            "Mevrouw de voorzitter, dit is natuurlijk gelul van een dronken aarbei.",
            "Medicijnen kunnen de kwaliteit van leven spectaculair verbeteren en zelfs mensen genezen. Maar ze zijn ongekend duur en dreigen daarmee te leiden tot onbetaalbare zorg.",
            "Mijn oproep is, was en blijft dat andere politieke partijen zaken zullen moeten doen met de PVV.",
            "Roken is ook heel lang normaal gevonden, maar geleidelijk is er steeds meer weerstand tegen ontstaan. Met de auto moet hetzelfde gebeuren: het is vies en ongezond.",
            "Er moet wel op tijd geleverd worden, anders krijgen we weer die sporthallen.",
            "Volgens de meest optimistische schatting kost het de Russen 60 uur om in Riga te staan. Als je in Den Haag woont klinkt dat ver weg. In Riga denken ze daar anders over.",
            "Laat dit een wake-upcall zijn. Veel mensen snappen Europa niet meer. Ze ergeren zich aan de regels die over ons worden uitgestort.",
            "Reden temeer voor geen versnelde toetreding tot de EU.",
            "Hij heeft nog steeds die rare gedachten. We willen hem niet bij de gewone gevangenen hebben.",
            "Een ordentelijk proces is belangrijker dan een datum.",
            "Ik dacht: who the fuck zijn jullie? Je kent me niet, alleen maar van de tv. Je hebt nog niet eens met me gesproken.",
            "De dag dat ik mijn moeder naar een verpleeghuis bracht, was de verdrietigste dag van mijn leven.",
            "Ik heb gezegd dat als het mijn verantwoordelijkheid was geweest, ik ze voor de zekerheid had gesloten.",
            "Minder! Minder! Minder!",
            "Nog maximaal 365 dagen tot aan de volgende verkiezingen voor de Tweede Kamer.",
            "Europa is in het hart getroffen.",
            "We moeten niet voor elke poep en scheet een referendum organiseren. Dan wordt de democratie een grapje.",
            "Wij geloven erin dat jij wijs en verstandig genoeg bent om door dit spel heen te prikken. Trap er dus niet in!",
            "Het is heel moeilijk om vertrouwen te houden in een minister wanneer je keer op keer ziet dat er achteraf toch net weer iets meer blijkt te zijn dan hij aanvankelijk beweerde.",
            "We staan klaar als een fitte bokser om het Nederlands belang centraal te stellen.",
            "Als je dingen wil veranderen, doe dat dan geleidelijk. Niet op de manier waarop RTL het doet. Daarmee vermoord je het Sinterklaasfeest",
            "Het is heel bijzonder dat de staatssecretaris van belastingzaken de Belastingdienst onder curatele stelt, want wie is er nu eigenlijk verantwoordelijk voor die Belastingdienst? ",
            "Wat de Amerikanen kunnen, dat kunnen wij ook. En daarom zal dat zeker een enorme stimulans zijn voor partijen als de mijne om hiermee door te gaan"
    };

    private static Random rnd = new Random();
    ;

    public static String getUitspraak() {
        int foo = rnd.nextInt(uitspraken.length);
        return uitspraken[foo];
    }
}
