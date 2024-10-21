import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //Od korisnika trazite unos 10 brojeva te u listi pronadite koji broj se najvise puta ponavlja.
    //Za rezultat ispisite broj koji se najvise puta ponavljao u listi te koliko se puta pojavio u listi.
    //Treba uzeti u obriz da su svi brojevi razliciti.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        int brojac;
        int i;

        for (i = 0; i < 10; i++) {
            System.out.println("Unesite element " + (i + 1) + " liste: ");
            int unos = scanner.nextInt();
            lista1.add(unos);
        }

        for (i = 0; i < lista1.size(); i++) {
            brojac = 0;
            for (int j = 0; j < lista1.size(); j++) {
                if (lista1.get(i).equals(lista1.get(j))) {
                    brojac++;
                }
            }
            lista2.add(brojac);
        }

        int maxBroj = 0;


        for (i = 0; i < lista2.size(); i++) {
            if (lista2.get(i) > maxBroj) {
                maxBroj = lista2.get(i);
            }
        }


        List<Integer> maxBrojevi = new ArrayList<>();
        for (i = 0; i < lista2.size(); i++) {
            if (lista2.get(i) == maxBroj) {
                if (!maxBrojevi.contains(lista1.get(i))) {
                    maxBrojevi.add(lista1.get(i));
                }
            }
        }

        if (maxBroj == 1) {
            System.out.println("Svi brojevi su različiti!");
        }

        else if (maxBrojevi.size()!=1){
            System.out.print("Brojevi koji se pojavljuju najviše puta (" + maxBroj + "): ");
            for (int broj : maxBrojevi) {
                System.out.print(broj + " ");
            }
            System.out.println();
        }
        else{
            System.out.println("Broj koji se pojavljuje najviše puta (" + maxBroj + "): "+maxBrojevi.get(0));
        }

        scanner.close();
    }
}