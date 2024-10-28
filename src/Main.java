import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite koju količinu novca želite vratiti:");
        double unos = scanner.nextDouble();
        double[] apoeni = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        vratiNovac(unos, apoeni);
    }

    public static void vratiNovac(double unos, double[] apoeni) {
        System.out.print("Novčanice koje treba vratiti: ");
        for (int i = 0; i < apoeni.length; i++) {
            while (unos >= apoeni[i]) {
                System.out.print(" "+apoeni[i]);
                unos -= apoeni[i];
            }
        }
    }
}

