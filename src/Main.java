import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NeispravniPodaciException {
        Automobil automobil1=new Automobil("ZG5806HD", "VW", 2019,4);
        Automobil automobil2=new Automobil("VT140AJ","Škoda",2009,5);
        Motocikl motocikl1=new Motocikl("ZG123A","BMW",2024,"jednocilindrični");
        Motocikl motocikl2=new Motocikl("VT321S","Honda",2011,"V-twin");
        EvidencijaVozila evidencijaVozila=new EvidencijaVozila();
        evidencijaVozila.dodajVozilo(automobil1);
        evidencijaVozila.dodajVozilo(automobil2);
        evidencijaVozila.dodajVozilo(motocikl1);
        evidencijaVozila.dodajVozilo(motocikl2);

        evidencijaVozila.spremiPodatkeUDatoteku("vozila.txt");
        evidencijaVozila.ucitajPodatkeIzDatoteke("vozila.txt");





    }


}