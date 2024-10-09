import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dobrodošli u kalkulator za dijeljenje!");

        System.out.println("Molim Vas unesite prvi broj:");

        double uneseniBroj1 = scanner.nextDouble();

        System.out.println("Molim Vas unesite drugi broj:");

        double uneseniBroj2 = scanner.nextDouble();


        System.out.println("Uneseni broj je: " + uneseniBroj1);
        System.out.println("Uneseni broj je: " + uneseniBroj2);

        double rezultat = uneseniBroj1/uneseniBroj2;

        System.out.println("Kvocijent dva unesena broja je: "+rezultat);

    }
}