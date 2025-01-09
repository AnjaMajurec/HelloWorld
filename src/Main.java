import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Polaznik> sviPolaznici = new ArrayList<>();

        HashMap<String, Polaznik> polazniciProvjeraPoEmailu = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Koliko polaznika želite unijeti: ");
        int brojPolaznika = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < brojPolaznika; i++) {
            String ime, prezime, email;


            while(true) {
                System.out.println("Unesite ime "+(i+1)+". polaznika: ");
                ime = scanner.nextLine();
                System.out.println("Unesite prezime "+(i+1)+". polaznika: ");
                prezime = scanner.nextLine();
                System.out.println("Unesite email  "+(i+1)+". polaznika: ");
                email = scanner.nextLine();
                if (polazniciProvjeraPoEmailu.containsKey(email)) {
                    System.out.println("Polaznik sa ovom email adresom već postoji!");
                }
                else {
                    break;
                }
            }
             Polaznik polaznik=new Polaznik(ime,prezime,email);
             sviPolaznici.add(polaznik);
             polazniciProvjeraPoEmailu.put(email, polaznik);

        }
        System.out.println(sviPolaznici.toString());
    }
}


