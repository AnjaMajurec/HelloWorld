import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //Napravi program koji će izračunati prosjek brojeva u listi, ali bez najmanjeg i najvećeg broja.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();
        System.out.println("Koliko elemenata želiš unijeti u listu? ");
        int velicinaListe = scanner.nextInt();
        for (int i = 0; i < velicinaListe; i++) {
            System.out.println("Unesi " + (i + 1) + ". element liste: ");
            int unos = scanner.nextInt();
            lista.add(unos);
        }
        System.out.println("Prosjek je: " + prosjek(lista));
    }
    private static Double prosjek(List<Integer> lista){
        int maxBroj = 0;
        int minBroj = lista.get(0);


        for(int i=0;i<lista.size();i++) {
            if (lista.get(i)>maxBroj){
                maxBroj=lista.get(i);
            }
            else if(lista.get(i)<minBroj){
                minBroj=lista.get(i);
            }

        }
        double zbroj=0;
        for (int i=0;i<lista.size();i++){
            zbroj+=lista.get(i);

        }
         return (zbroj-maxBroj-minBroj)/(lista.size()-2);
    }
}