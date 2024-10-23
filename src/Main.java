import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //Tražiti od korisnika da unese broj elemenata u listi te popuni elemente liste.
    //Nakon toga pretražiti po listi da li postoji ijedan duplikat, ukoliko postoji ispisi vrijednost true, ukoliko ne postoji ispisi vrijednost false.

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
        System.out.println("U navedenoj listi postoji duplikat: " + provjera(lista));
    }
    private static Boolean provjera(List<Integer> lista){
        for(int i=0;i<lista.size();i++){
            int brojac=0;
            for(int j=0;j<lista.size();j++){
                if(lista.get(i).equals(lista.get(j))){
                    brojac++;
                }
            }
            if(brojac>=2){
                return true;
            }
        }
        return false;
    }
}