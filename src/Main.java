import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi za koliko proizvoda želiš izračunati cijenu s popustom: ");
        Integer brojProizvoda = scanner.nextInt();

        for (int i = 0; i < brojProizvoda; i++) {
            novaCijenaProizvoda();
        }
    }
        public static void novaCijenaProizvoda(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesi naziv proizvoda: ");
            String nazivProizvoda= scanner.nextLine();
            System.out.println("Unesi cijenu proizvoda: ");
            BigDecimal cijenaProizvoda=scanner.nextBigDecimal();
            System.out.println("Unesi popust na proizvod: ");
            BigDecimal unosPopusta=scanner.nextBigDecimal();

            Proizvod proizvod1= new Proizvod(nazivProizvoda, cijenaProizvoda);
            proizvod1.postaviPopust(unosPopusta);
            System.out.println("Nova cijena proizvoda iznosi: "+proizvod1.izracunajCijenu());
        }
}

