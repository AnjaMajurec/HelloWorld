import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Pogađanje tajnog broja!");

                int tajniBroj = 7;
                int pogodak;

                do{
                    System.out.println("Pogodi broj: ");
                    pogodak = scanner.nextInt();

                }
                while (pogodak > tajniBroj || pogodak < tajniBroj);
                System.out.println("Bravo, uspješno ste pogodili tajni broj 7.");

            }
        }