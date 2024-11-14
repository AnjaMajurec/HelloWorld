import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Napiši Java program koji omogućuje korisniku unos broja, a zatim računa faktorijel tog broja.
    //Program treba obraditi iznimke koje se mogu pojaviti tijekom unosa i računanja faktorijela.
    //Ispiši poruku korisniku da unese broj.
    // Koristi Scanner za unos broja od korisnika.
    // Obradi iznimke koje se mogu pojaviti tijekom unosa. Ako korisnik unese nešto što nije broj,
    // ispiši odgovarajuću poruku i zatraži ponovni unos.
    // Računaj faktorijel unesenog broja.(funkcija throws Exception)
    // Obradi iznimke koje se mogu pojaviti tijekom računanja faktorijela. Na primjer,
    // obradi situaciju kada korisnik unese negativan broj jer faktorijel nije definiran za negativne brojeve.
    // Ispiši rezultat ili poruku o greški, ovisno o tome je li računanje faktorijela uspješno ili ne.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean provjera = false;

        do {
            try {
                System.out.println("Unesite broj za koji računamo faktorijel: ");
                int broj = scanner.nextInt();
                provjera = true;
                System.out.println("Faktorijel broja " + broj + " iznosi " + izracunajFaktorijel(broj) + ".");


            } catch (InputMismatchException e) {
                System.out.println("Greška. Unesite cijeli broj: ");
                scanner.next();

            } catch (Exception e) {
                System.out.println("Greška: " + e.getMessage());
                provjera = false;

            }

        } while (!provjera);

    }

    public static double izracunajFaktorijel(int broj) throws Exception {
        if (broj < 0.0) {
            throw new Exception("Faktorijel nije definiran za negativne brojeve.");
        } else if (broj == 0) {
            return 1;
        } else {
            double faktorijel = 1;
            for (int i = 1; i <= broj; i++) {
                faktorijel = faktorijel * i;
            }
            return faktorijel;
        }
    }
}