import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                //ZADATAK 1
                //Napišite program koji će izračunati sumu svih brojeva od 1 do N, gdje je N pozitivan cijeli broj unesen od strane korisnika.

                System.out.println("Unesite jedan cijeli broj: ");
                int broj = scanner.nextInt();
                int zbroj = 0;

                for (int i=1; i<(broj+1);i++){
                    zbroj+=i;
                }
                System.out.println("Zbroj brojeva od 1 do " + broj + " iznosi " + zbroj + ".");



            }
        }