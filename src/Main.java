import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                //Zadatak 2: Brojanje znamenki broja
                //Napiši program koji prima cijeli broj od korisnika i  izračuna broj znamenki unesenog broja.

                System.out.println("Unesi jedan cijeli broj: ");
                int unos = scanner.nextInt();
                int brojac = 1;
                int a = unos / 10;
                while (a != 0) {
                    brojac++;
                    a = a / 10;

                    }

                System.out.println("Broj znamenki unesenog broja " + unos + " je " + brojac + ".");


            }
        }