import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //2. Najveći i najmanji broj
        //Napravite program koji traži od korisnika unos 15 decimalnih brojeva (tip double) i sprema ih u listu. Zatim pronađite i ispišite:
        //Najveći broj,
        //Najmanji broj.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi 15 decimalnih brojeva:");
        List<Double> decimalniBrojevi=new ArrayList<>();

        for(int i =0;i<15;i++){
            System.out.println("Unesi "+(i+1)+". broj: ");
            decimalniBrojevi.add(scanner.nextDouble());
        }
        double najmanjiBroj=decimalniBrojevi.get(0);
        double najveciBroj=decimalniBrojevi.get(0);

        for (Double i : decimalniBrojevi) {
            if(i<najmanjiBroj){
                najmanjiBroj=i;
            }
            else if(i>najveciBroj){
                najveciBroj=i;
            }
        }
        System.out.println("Najmanji broj je: "+najmanjiBroj+", a nejveći broj je: "+najveciBroj);
    }
}