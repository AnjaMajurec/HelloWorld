import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        //ZADATAK 1
        System.out.println("+++++ZADATAK 1+++++");
        HashSet<String> studenti = new HashSet<>();

        studenti.add("Anja");
        studenti.add("Mirta");
        studenti.add("Lara");
        studenti.add("Ivor");

        if (studenti.contains("Mirta")) {
            System.out.println("HashSet sadrži studenta pod imenom Mirta.");
        } else {
            System.out.println("HashSet NE sadrži studenta pod imenom Mirta.");
        }

        for (String student : studenti) {
            System.out.println("HashSet: " + student);
        }

        studenti.remove("Anja");

        System.out.println("+++++NAKON BRISANJA+++++");
        for (String student : studenti) {
            System.out.println("HashSet: " + student);
        }
        System.out.println("+++++ZADATAK 2+++++");

        TreeSet<String> gradovi = new TreeSet<>();

        gradovi.add("Zagreb");
        gradovi.add("Osijek");
        gradovi.add("Rijeka");
        gradovi.add("Split");
        gradovi.add("Makarska");

        System.out.println("Elementi u TreeSet-u su: " + gradovi);

        System.out.println("Prvi element u TreeSet-u je: " + gradovi.first());
        System.out.println("Zadnji element u TreeSet-u je: " + gradovi.last());

        gradovi.remove("Rijeka");

        System.out.println("+++++NAKON BRISANJA+++++");
        System.out.println("Elementi u TreeSet-u su: " + gradovi);

        System.out.println("+++++ZADATAK 3+++++");

        HashSet<String> odjelA = new HashSet<>();

        odjelA.add("Anja");
        odjelA.add("Mirta");
        odjelA.add("Lara");
        odjelA.add("Ivor");

        HashSet<String> odjelB = new HashSet<>();

        odjelB.add("Lovro");
        odjelB.add("Ivana");
        odjelB.add("Lara");
        odjelB.add("Anja");

        HashSet<String> unija = new HashSet<>(odjelA);
        unija.addAll(odjelB);
        System.out.println("Unija: " + unija);

        HashSet<String> presjek = new HashSet<>(odjelA);
        presjek.retainAll(odjelB);
        System.out.println("Presjek: " + presjek);

        HashSet<String> razlika = new HashSet<>(odjelA);
        razlika.removeAll(odjelB);
        System.out.println("Razlika (odjelA - odjelB): " + razlika);
        }
    }

