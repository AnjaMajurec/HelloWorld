import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Zbrajanje");

                int zbroj = 0;
                int unos = 1;

                while (unos != 0){
                    System.out.println("Unesi broj, za kraj programa unesi 0.");
                    unos = scanner.nextInt();
                    zbroj+=unos;
                }

                System.out.println("Zbroj prethodno unesenih brojeva je: " + zbroj);

            }
        }