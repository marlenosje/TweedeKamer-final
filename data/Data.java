/**
 * @author Paul Tonk
 * @version 1.0 mrt 2019
 */
package data;

import java.util.ArrayList;
import java.util.Random;

import personen.Interviewer;
import personen.Persoon;
import personen.TweedeKamerlid;
import personen.Bode;
import personen.BodeInterface;
import commissies.*;


public class Data {
    private static Random rnd = new Random();
    private static ArrayList<ArrayList<? extends Persoon>> personen = new ArrayList<>();
    private static ArrayList<CommissieAlgemeen> actievecommissies = new ArrayList<>();

    public static ArrayList<TweedeKamerlid> getKamerleden() {
        ArrayList<TweedeKamerlid> rv = new ArrayList<>();

        TweedeKamerlid thieme = new TweedeKamerlid();
        thieme.setGeboortedatum("6 maart 1972");
        thieme.setGender('V');
        thieme.setNaam("Thieme");
        thieme.setPartij("PvdD");

        TweedeKamerlid rutte = new TweedeKamerlid();
        rutte.setGeboortedatum("14 februari 1967");
        rutte.setGender('M');
        rutte.setNaam("Rutte");
        rutte.setPartij("VVD");

        TweedeKamerlid baudet = new TweedeKamerlid();
        baudet.setGeboortedatum("28 januari 1983");
        baudet.setGender('M');
        baudet.setNaam("Baudet");
        baudet.setPartij("FvD");

        TweedeKamerlid agema = new TweedeKamerlid();
        agema.setGeboortedatum("16 september 1976");
        agema.setGender('V');
        agema.setNaam("Agema");
        agema.setPartij("PVV");

        TweedeKamerlid jansen = new TweedeKamerlid();
        jansen.setGeboortedatum("6 april 1972");
        jansen.setGender('V');
        jansen.setNaam("Jansen");
        jansen.setPartij("PvdD");

        TweedeKamerlid peters = new TweedeKamerlid();
        peters.setGeboortedatum("14 april 1967");
        peters.setGender('M');
        peters.setNaam("Peters");
        peters.setPartij("VVD");

        TweedeKamerlid cornellissen = new TweedeKamerlid();
        cornellissen.setGeboortedatum("28 november 1983");
        cornellissen.setGender('M');
        cornellissen.setNaam("Cornellissen");
        cornellissen.setPartij("FvD");

        TweedeKamerlid wilders = new TweedeKamerlid();
        wilders.setGeboortedatum("16 juni 1976");
        wilders.setGender('M');
        wilders.setNaam("Wilders");
        wilders.setPartij("PVV");

        rv.add(thieme);
        rv.add(rutte);
        rv.add(baudet);
        rv.add(agema);
        rv.add(jansen);
        rv.add(peters);
        rv.add(cornellissen);
        rv.add(wilders);

        return rv;
    }

    public static ArrayList<Interviewer> getPersmuskieten() {
        ArrayList<Interviewer> rv = new ArrayList<>();

        Interviewer castricum = new Interviewer();
        castricum.setNaam("Rutger van Castricum");
        castricum.setGender('M');
        castricum.setGeboortedatum("29 mei 1979)");
        castricum.setOmroep("PowNeds");

        Interviewer plag = new Interviewer();
        plag.setNaam("Ghislaine Plag");
        plag.setGender('V');
        plag.setGeboortedatum("4 juni 1975");
        plag.setOmroep("NCRV");

        Interviewer berg = new Interviewer();
        berg.setNaam("Jurgen van den Berg");
        berg.setGender('M');
        berg.setGeboortedatum("8 december 1964");
        berg.setOmroep("NCRV");

        Interviewer veenhoven = new Interviewer();
        veenhoven.setNaam("Willemijn Veenhoven");
        veenhoven.setGender('V');
        veenhoven.setGeboortedatum("19 november 1974");
        veenhoven.setOmroep("BNN");

        rv.add(castricum);
        rv.add(plag);
        rv.add(berg);
        rv.add(veenhoven);

        return rv;
    }

    public static ArrayList<Bode> getBode() {
        ArrayList<Bode> rv = new ArrayList<>();

        Bode piet = new Bode();
        piet.setNaam("Pietje Puk");
        piet.setGender('M');
        piet.setGeboortedatum("19 januari 1950");
        piet.kiesHoofdBedekking();

        Bode joop = new Bode();
        joop.setNaam("Snelle Joop");
        joop.setGender('M');
        joop.setGeboortedatum("5 mei 1992");
        joop.kiesHoofdBedekking();

        Bode harry = new Bode();
        harry.setNaam("Handige Harry");
        harry.setGender('M');
        harry.setGeboortedatum("5 december 2000");
        harry.kiesHoofdBedekking();

        Bode jan = new Bode();
        jan.setNaam("Jan Klaasen");
        jan.setGender('M');
        jan.setGeboortedatum("19 december 1984");
        jan.kiesHoofdBedekking();

        rv.add(piet);
        rv.add(jan);
        rv.add(joop);
        rv.add(harry);

        return rv;
    }

    public static ArrayList<CommissieAlgemeen> getCommissie() {
        ArrayList<CommissieAlgemeen> commissie = new ArrayList<>();

        //Landbouw Commissies
        LandbouwCommissie land1 = new LandbouwCommissie();
        land1.setNaamCommissie("Commissie voor onderzoek naar landbouwmethoden");
        land1.setOprichtingsDatum("19 feb 2019");
        commissie.add(land1);

        LandbouwCommissie land2 = new LandbouwCommissie();
        land2.setNaamCommissie("Commissie voor onderzoek naar maaiwerkzaamheden");
        land2.setOprichtingsDatum("01 feb 2019");
        commissie.add(land2);

        //Snelweg Commissies
        SnelwegCommissie snelweg1 = new SnelwegCommissie();
        snelweg1.setNaamCommissie("Commissie onderzoek maximum snelheden");
        snelweg1.setOprichtingsDatum("15 okt 2018");
        commissie.add(snelweg1);

        SnelwegCommissie snelweg2 = new SnelwegCommissie();
        snelweg2.setNaamCommissie("Commissie asfaltproblemen");
        snelweg2.setOprichtingsDatum("02 jan 2019");
        commissie.add(snelweg2);

        //Bioindustrie Commisies
        BioindustrieCommissie bio1 = new BioindustrieCommissie();
        bio1.setNaamCommissie("Commissie Ethiek en BioIndustrie");
        bio1.setOprichtingsDatum("25 dec 2017");
        commissie.add(bio1);

        BioindustrieCommissie bio2 = new BioindustrieCommissie();
        bio2.setNaamCommissie("Commissie BioIndustrie nader bekeken");
        bio2.setOprichtingsDatum("01 jun 2018");
        commissie.add(bio2);

        return commissie;
    }

    public static CommissieAlgemeen getRandomCommisssie() {
        int foo = rnd.nextInt(getCommissie().size());
        return getCommissie().get(foo);
    }

    public static Interviewer getRandomInterviewer() {
        int foo = rnd.nextInt(getPersmuskieten().size());
        return getPersmuskieten().get(foo);
    }

    public static TweedeKamerlid getRandomPoliticus() {
        int foo = rnd.nextInt(getKamerleden().size());
        return getKamerleden().get(foo);
    }

    public static Bode getRandomBode() {
        int foo = rnd.nextInt(getBode().size());
        return getBode().get(foo);
    }

    public static ArrayList<ArrayList> getPersonen() {
        ArrayList<ArrayList> aanwezig = new ArrayList<>();
        aanwezig.add(getKamerleden());
        aanwezig.add(getPersmuskieten());
        aanwezig.add(getBode());
        return aanwezig;
    }

    public static ArrayList<BodeInterface> getBriefjesRondbrenger()  //Maak een Array met bodes en interviewers die briefjes rondbrengen
    {
        ArrayList<BodeInterface> rv = new ArrayList<>();
        rv.addAll(getBode());   //haal bodes op
        rv.addAll(getPersmuskieten());  //haal interviewers op
        return rv;
    }

    public static ArrayList<CommissieAlgemeen> getActieveCommissies() {
        return actievecommissies;
    }

}
