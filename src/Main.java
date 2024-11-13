import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Zadatak: Upravljanje Zaposlenicima i Izračun Plaće
    // Napravite aplikaciju koja prati različite vrste zaposlenika i izračunava njihove plaće ovisno o uvjetima rada i radnim satima.
    //Kreirajte osnovnu klasu koja će sadržavati osnovne podatke o zaposleniku, kao što su:
    //ime zaposlenika,
    // osnovna plaća (tipa BigDecimal),
    //broj radnih sati zaposlenika.
    // Definirajte metode koje će omogućiti ispis podataka zaposlenika i izračun plaće.
    // Na temelju osnovne klase, kreirajte dvije specifične vrste zaposlenika, npr. "Stalni" i "Sezonski":
    //Prva vrsta zaposlenika prima bonus od 15% na osnovnu plaću ako broj radnih sati prelazi 160.
    //Druga vrsta zaposlenika ima izračun po satu. Ako zaposlenik radi više od 200 sati, ostvaruje dodatni bonus od 10% na ukupnu plaću.
    //Omogućite unos podataka za svakog zaposlenika putem konzole:
    // Korisnik unosi ime, osnovnu plaću, broj radnih sati i vrstu zaposlenika.
    //Ovisno o vrsti zaposlenika, koristi se odgovarajući način izračuna plaće.
    //Kreirajte glavni program u kojem:
    //Spremate zaposlenike u listu (List).
    //Nakon unosa, program prolazi kroz listu i ispisuje podatke o svakom zaposleniku, uključujući izračun plaće prema definiranim pravilima.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Zaposlenik> zaposlenici = new ArrayList<>();
        do {
            System.out.println("Unesite ime zaposlenika: ");
            String ime = scanner.nextLine();
            System.out.println("Unesi osnovnu plaću zaposlenika: ");
            BigDecimal osnovnaPlaca = scanner.nextBigDecimal();
            System.out.println("Unesite broj radnih sati: ");
            Integer brojRadnihSati = scanner.nextInt();
            System.out.println("Unesite vrstu zaposlenika: (stalni-1, sezonski-2)");
            Integer odabir = scanner.nextInt();


            if (odabir == 1) {
                zaposlenici.add(new StalniZaposlenik(ime, osnovnaPlaca, brojRadnihSati));
            } else if (odabir == 2) {
                zaposlenici.add(new SezonskiZaposlenik(ime, osnovnaPlaca, brojRadnihSati));
            } else {
                System.out.println("Krivi unos vrste zaposlenika. Pokušajte ponovno.");
            }
            System.out.println("Želite li dodati još jednog zaposlenika? (da-1, ne-0)");
            Integer nastavak = scanner.nextInt();
            if (nastavak == 0) {
                break;
            }
            scanner.nextLine();

        } while (true);
        System.out.println("Popis zaposlenika: ");
        for (Zaposlenik zaposlenik : zaposlenici) {
            zaposlenik.ispisPodataka();
        }
        scanner.close();
    }
}