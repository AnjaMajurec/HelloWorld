import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //Traziti unos velicine polja u koje korisnik kasnije unosi vrijednosti pojedinog elementa polja. Potrebno je ispisati maximalnu vrijednost elementa polja.
        //Npr, 3 je velicina polja te je korisnik unjeo 1,3,5. Program treba pronaci najvecu vrijednost te u obom slucaju ispisati 5.

        Scanner scanner = new Scanner(System.in);

        int maxBroj = 0;

        System.out.println("Molim Vas unesite veličinu polja: ");
        int velicinaPolja = scanner.nextInt();

        int[] polje = new int[velicinaPolja];

        for (int i=0; i<velicinaPolja;i++){
            System.out.println("Upišite vrijednost elementa s indeksom: " + i);
            int unos = scanner.nextInt();
            polje[i]=unos;
            if (polje[i] > maxBroj){
                maxBroj = polje[i];
            }

        }

        System.out.println("Najveća vrijednost broja u ovom polju je: " + maxBroj);

    }
}