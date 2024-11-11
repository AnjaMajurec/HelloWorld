import java.util.Scanner;
//Zadatak: Sučelje za Različite Tipove Plaćanja
//Opis zadatka:
//Kreirajte aplikaciju koja koristi sučelje za implementaciju različitih metoda plaćanja.
// Svaka vrsta plaćanja treba imati svoju specifičnu implementaciju za metodu platiti(),
// a vrsta plaćanja može biti: kreditna kartica, gotovina ili PayPal.
//Definirajte sučelje Placanje s dvije metode:
//void platiti(double iznos) – metoda koja prima iznos i obrađuje plaćanje za navedeni iznos.
//String getDetalje() – metoda koja vraća detalje o transakciji, poput vrste plaćanja i iznosa.
//Kreirajte 3 klase koje implementiraju sučelje Placanje:
//KreditnaKartica: Klasa koja implementira metodu za plaćanje putem kreditne kartice.
//        Gotovina: Klasa koja implementira metodu za plaćanje u gotovini.
//PayPal: Klasa koja implementira metodu za plaćanje putem PayPala.
//Glavna klasa: U glavnoj metodi, korisnik unosi iznos koji želi platiti.
// Zatim, na temelju odabrane metode plaćanja (kreditna kartica, gotovina ili PayPal),
// treba pozvati odgovarajuću metodu za plaćanje.
//Ispišite odgovarajuće poruke za svaku vrstu plaćanja, uključujući i detalje o transakciji, pozivajući metodu getDetalje():
//        "Plaćanje putem kreditne kartice u iznosu od: 200.00 EUR."
//        "Plaćanje u gotovini u iznosu od: 150.00 EUR."
//        "Plaćanje putem PayPala u iznosu od: 100.00 EUR."

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koji iznos želite platiti? ");
        double iznos= scanner.nextDouble();
        System.out.println("Kako želite provesti transakciju: (1-kreditna kartica, 2-PayPal, 3-gotovina): ");
        int izbor= scanner.nextInt();

        Placanje nacinPlacanja=null;

        if(izbor==1){
            nacinPlacanja=new KreditnaKartica();
        }
        else if(izbor==2){
            nacinPlacanja=new PayPal();
        }
        else if(izbor==3){
            nacinPlacanja=new Gotovina();
        }
        else{
            System.out.println("Neispravan unos");
        }
        nacinPlacanja.platiti(iznos);
        System.out.println(nacinPlacanja.getDetalje());
        System.out.println("Iznos koji je plaćen je "+nacinPlacanja.vratiIznos()+" eura.");


    }

}