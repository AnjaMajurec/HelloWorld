import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Napravite program za pracenje vozia u voznom parku. Program treba sadržavati:
        //Apstraktnu klasu koja predstavlja osnovne podatke o vozilu(npr. marka, model, registracija).
        //Apstraktna metoda koja vraća detaljan opis vozila.
        //Dvije izvedene klase:
        //Automobil(ima dodatne informacije poput broja sjedala i vrste goriva).
        //Kamion(ima dodatne informacije poput nosivosti i prikolice.
        //U glavnom dijelu treba biti:
        //Stvoriti listu vozila u voznom parku(nekoliko automobila i kamiona).
        //Implementirati metodu za pretraživanje vozila u listi prema registraciji.
        //Ipisati sve podatke o pronađenom vozilu.
        //Ako vozilo nije pronađeno ispisati poruku da ne postoji u sustavu.
        //Dodati mogućnost ispisvanja svih vozila u voznom parku.
        Scanner scanner = new Scanner(System.in);
        List<Vozilo> vozila=new ArrayList<>();

        Auto auto1=new Auto("VW", "Polo","ZG5806HD",5,"benzin");
        vozila.add(auto1);
        Auto auto2=new Auto("Škoda", "Octavia","VT140AJ",5,"dizel");
        vozila.add(auto2);

        Kamion kamion1=new Kamion("Mercedes", "Actros","ZG3241AS", 430.00,"da");
        vozila.add(kamion1);
        Kamion kamion2=new Kamion("Volvo", "Atego", "VT003S",200.00,"ne");
        vozila.add(kamion2);
        while(true){
            System.out.println("Za pretraživanje vozila po registraciji upišite 1, a za ispis svih vozila u voznom parku 2, za izlaz 0 ");
            int odabir= scanner.nextInt();
            scanner.nextLine();

            if (odabir==0){
                System.out.println("Izašli ste iz voznog parka.");
                break;
            }
            else if(odabir==1){
                System.out.println("Unesi registraciju vozila čije podatke želiš: ");
                String registracijaKorisnik= scanner.nextLine();
                Vozilo vozilo=pretraziVoziloPoRegistraciji(vozila, registracijaKorisnik);
                if(vozilo==null){
                    System.out.println("U bazi ne postoji vozilo s tom registracijom.");
                }
                else{
                    vozilo.detaljanOpisVozila();
                }

            }
            else{
                for (Vozilo vozilo : vozila) {
                    vozilo.detaljanOpisVozila();
                }
            }
        }

    }
    public static Vozilo pretraziVoziloPoRegistraciji(List<Vozilo> vozila, String registracijaKorisnik) {
        for (Vozilo vozilo : vozila) {
            if (vozilo.getRegistracijaVozila().equals(registracijaKorisnik)) {
                return vozilo;
            }
        }
        return null;
    }
}