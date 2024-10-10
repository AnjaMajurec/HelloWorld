import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("KALKULATOR!");

                System.out.println("Molim Vas unesite prvi broj:");

                double uneseniBroj1 = scanner.nextDouble();

                System.out.println("Molim Vas unesite drugi broj:");

                double uneseniBroj2 = scanner.nextDouble();

                System.out.println("Molim Vas unesite matematičku radnju koju želite izvršiti (1-zbrajanje, 2-oduzimanje, 3-množenje, 4-dijeljenje):");

                int radnja = scanner.nextInt();

                if (radnja == 1){
                    double rezultat = uneseniBroj1 + uneseniBroj2;
                    System.out.println("Korisnik je izabrao zbrajanje dva unesena broja " + uneseniBroj1 + " i " + uneseniBroj2 + " te je rezultat jednak: " + rezultat + ".");
                }

                else if (radnja == 2){
                    double rezultat = uneseniBroj1 - uneseniBroj2;
                    System.out.println("Korisnik je izabrao oduzimanje dva unesena broja " + uneseniBroj1 + " i " + uneseniBroj2 + "  te je rezultat jednak: " + rezultat + ".");
                }
                else if (radnja == 3){
                    double rezultat = uneseniBroj1 * uneseniBroj2;
                    System.out.println("Korisnik je izabrao množenje dva unesena broja " + uneseniBroj1 + " i " + uneseniBroj2 + "  te je rezultat jednak: " + rezultat + ".");
                }
                else {
                    double rezultat = uneseniBroj1 / uneseniBroj2;
                    System.out.println("Korisnik je izabrao dijeljenje dva unesena broja " + uneseniBroj1 + " i " + uneseniBroj2 + "  te je rezultat jednak: " + rezultat + ".");
                }

            }
        }