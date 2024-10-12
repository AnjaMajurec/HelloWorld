import java.sql.SQLOutput;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Zadatak 3: Unos brojeva dok ne postignemo određeni zbroj
        //Napiši program koji traži unos brojeva od korisnika sve dok zbroj svih unesenih brojeva ne dostigne ili prijeđe unaprijed definirani ciljni zbroj.
        //Ako korisnik unese negativan broj, program ga ignorira i traži novi unos.
        //Ako korisnik unese 0, prekida unos i program ispisuje trenutni zbroj.
        //Kada se zbroj dostigne ili premaši, program završava i ispisuje koliko je pokušaja korisnik napravio i konačni zbroj.

        int cilj = 10;
        int zbroj = 0;
        int brojac = 0;

        while (zbroj < cilj) {
            System.out.println("Unesi broj: ");
            int pokusaj = scanner.nextInt();
            if (pokusaj > 0) {
                zbroj += pokusaj;
                brojac++;
            }
            else if (pokusaj == 0) {
                System.out.println("Trenutni zbroj iznosi " + zbroj + ".");
                break;
            }

        }
        if (zbroj >= cilj) {
            System.out.println("Cilj koji je korisnik trebao premašiti je " + cilj + ". Konačni zbroj koji je korisnik unio iznosi " + zbroj + ", postignut u " + brojac + " pokušaja.");
        }
    }
}