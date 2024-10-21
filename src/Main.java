import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //Napiši program koji od korisnika traži unos niza brojeva i sprema ih u List-u.
        //Pronađi najmanji i najveći broj, zamijeni ih međusobno i ispiši novu List-u.

        Scanner scanner = new Scanner(System.in);

        List <Integer> lista1 = new ArrayList <>();
        List <Integer> lista2 = new ArrayList <>();
        int unos;
        int maxBroj = 0;
        int minBroj;


        System.out.println("Koliko brojeva ćete unesti u listu: ");
        int broj = scanner.nextInt();

        int i=0;
        do {
            System.out.println("Unesite element liste: ");
            unos = scanner.nextInt();
            lista1.add(unos);
            i++;
        } while(i<broj);

        minBroj = lista1.get(0);

        for (i=0; i < lista1.size(); i++){
            if (lista1.get(i) > maxBroj){
                maxBroj = lista1.get(i);
            }
            else if (lista1.get(i) < minBroj){
                minBroj = lista1.get(i);
            }
        }
        System.out.println("Lista brojeva koju je korisnik unio:");
        for (i=0; i<lista1.size();i++){
            System.out.println(lista1.get(i));
        }
        for (i=0;i<lista1.size();i++){
            if (lista1.get(i)==maxBroj){
                lista2.add(minBroj);
            }
            else if (lista1.get(i)==minBroj){
                lista2.add(maxBroj);
            }
            else{
                lista2.add(lista1.get(i));
            }
        }
        System.out.println("Lista brojeva nakon što su pronađeni i međusobno zamijenjeni najveći i najmanji broj: ");
        for (i=0; i<lista2.size();i++){
            System.out.println(lista2.get(i));
        }
    }
}









