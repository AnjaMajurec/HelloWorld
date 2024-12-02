import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1. Brojanje parnih i neparnih brojeva
        //Napravite program koji traži od korisnika unos 10 cijelih brojeva. Spremite te brojeve u listu i zatim:
        //Prebrojite koliko je parnih, a koliko neparnih brojeva.
        //Ispišite rezultate.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi 10 cijelih brojeva:");
        List<Integer> cijeliBrojevi=new ArrayList<>();
        int parniBrojevi=0;
        int neparniBrojevi=0;
        for(int i =0;i<10;i++){
            System.out.println("Unesi "+(i+1)+". broj: ");
            cijeliBrojevi.add(scanner.nextInt());
        }
        for (Integer i : cijeliBrojevi) {
            if(i%2==0){
                parniBrojevi++;
            }
            else{
                neparniBrojevi++;
            }

        }
        System.out.println("Parnih brojeva je: "+parniBrojevi+", a neparnih brojeva: "+neparniBrojevi);
    }
}