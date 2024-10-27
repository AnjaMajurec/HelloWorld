import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // Zadatak 2
    // Telefonski imenik:
    // Napravi program koji simulira telefonski imenik koristeći dvije paralelne liste:
    // Lista u koju se spremaju imena, i lista u kojoj se sprema brojevi
    // Kod prvog odabira korisnik unosi ime i broj koji se spremaju u svoje liste
    // Korisnik ima mogucnost odabira, te za svaki odabir treba omoguciti odredenu funkcionalnost sa slike.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> ime = new ArrayList<>();
        List<String> broj = new ArrayList<>();

        System.out.println("TELEFONSKI IMENIK");
        int radnja = 1;
        do {
            if (radnja == 1) {
                System.out.println("Unesi korisnikovo ime: ");
                ime.add(scanner.nextLine());
                System.out.println("Unesi korisnikov broj telefona: ");
                broj.add(scanner.nextLine());
            }
            else if (radnja == 2) {
                pretraziPoImenu(ime, broj);
            }
            else if (radnja == 3) {
                pretraziPoBroju(ime,broj);
            }
            else if (radnja == 4) {
                ispisiSve(ime,broj);
            }
            System.out.println("Odaberite radnju koju želite izvršiti brojevima 1-5: ");
            System.out.println("1 - Dodaj kontakt, 2 - Pretraži po imenu, 3 - Pretraži po broju, 4 - Ispiši sve, 5 - Izlaz");
            radnja = scanner.nextInt();
            scanner.nextLine();
        } while (radnja < 5);
        System.out.println("Izašli ste iz telefonskog imenika.");

    }

    public static void pretraziPoImenu(List<String> ime, List<String> broj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite korisnikovo ime kako biste dobili njegov broj: ");
        String korisnik = scanner.nextLine();
        for (int i = 0; i < ime.size(); i++) {
            if (ime.get(i).equals(korisnik)) {
                System.out.println("Korisnikov broj je: " + broj.get(i));
                return;
            }
        }
    }
    public static void pretraziPoBroju(List<String> ime, List<String> broj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite korisnikov broj kako biste dobili njegovo ime: ");
        String pretragaBroj = scanner.nextLine();
        for (int i = 0; i < ime.size(); i++) {
            if (broj.get(i).equals(pretragaBroj)) {
                System.out.println("Korisnikovo ime je: " + ime.get(i));
                return;
            }
        }
    }
    public static void ispisiSve (List <String> ime, List <String> broj) {
        System.out.println("Imena i brojevi korisnika iz telefonskog imenika: ");
        for(int i=0; i<ime.size();i++){
            System.out.println(ime.get(i)+" "+broj.get(i));
        }
    }
}
