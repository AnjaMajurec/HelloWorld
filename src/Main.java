import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Napraviti funkciju koja provjerava da li je lista uzlazno sortirana.
    // Prethodno, listu popunjava korisnik svojim unosom.
    // Funkcija treba vratiti true/false.
    // Na kraju programa korisniku ispisati da li je lista sortirana ili ne.

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
        System.out.println("Navedena lista je sortirana: " + provjera(lista));
    }
    private static Boolean provjera(List<Integer> lista){
        for(int i=1;i<lista.size();i++){
            if (lista.get(i-1)<=lista.get(i)){
                continue;
            }
            else{
                return false;
            }
        }
    return true;
    }
}