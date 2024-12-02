import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //3. Zbrajanje pozitivnih i negativnih brojeva
        //Korisnik unosi 20 cijelih brojeva. Spremite ih u listu i:
        //Zbrojite sve pozitivne brojeve,
        //Zbrojite sve negativne brojeve,
        //Ispišite oba rezultata.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi 20 cijelih brojeva:");
        List<Integer> cijeliBrojevi=new ArrayList<>();

        for(int i =0;i<20;i++){
            System.out.println("Unesi "+(i+1)+". broj: ");
            cijeliBrojevi.add(scanner.nextInt());
        }
        Integer zbrojPozitivnihBrojeva=0;
        Integer zbrojNegativnihBrojeva=0;

        for (Integer i : cijeliBrojevi) {
            if(i<0){
                zbrojNegativnihBrojeva+=i;            }
            else{
                zbrojPozitivnihBrojeva+=i;
            }
        }
        System.out.println("Zbroj pozitivnih brojeva je: "+zbrojPozitivnihBrojeva+", a zbroj negativnih brojeva je: "+zbrojNegativnihBrojeva);
    }
}