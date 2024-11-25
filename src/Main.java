import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Napravite program koji simulira sustav za upravljanje zaposlenicima u tvrtki. Svaki zaposlenik ima svoje podatke,
        //a tvrtka vodi evidencij svih zaposlenika. Program treba omogućiti dodavanje zaposlenika, ispis svih zaposlenika i
        //i pronalaženje zaposlenika s najvećom plaćom.

        //Omogućite korisniku unos podataka o zaposlenicima.
        //Korisite metode klase Tvrtka za dodavanje, ispis i pronalaženje najveće plaće. Pronađite zaposlenika s najvećom plaćom
        // i ispisite njegove podatke.
        // Program treba tražiti od korisnika unos podataka za barem 3 zaposlenika (ime, prezime, plaća). Korisite metodu
        //ispisZaposlenika() za prikaz svih zaposlenika.
        //Prikažite zaposlenika s najvećom plaćom pomoću metode pronadjiNajvecuPlacu().

        //Drugi dio zadatka:
        //Napravite vlastitu klasu za grešku ako korisnik unese praznu vrijednost za ime ili prezime.
        //Napravite vlastitu klasu za pogrešku korisnika ukoliko se unese iznos place koji je manje ili jednak nuli.
        Scanner scanner = new Scanner(System.in);
        Tvrtka tvrtka = new Tvrtka("Končar");
        while (true) {
            String ime = "";
            String prezime = "";
            double placa = 0.00;

            try {
                System.out.println("Unesi ime zaposlenika: (ili 0 za kraj!)");
                ime = scanner.nextLine();
                if (ime.equals("0")) {
                    System.out.println("Unos zaposlenika je završen.");
                    break;
                }
                if (ime.isEmpty()) {
                    throw new EmptyNameOrSurnameException("Ime ne može biti prazno!");
                }
                System.out.println("Unesi prezime zaposlenika: ");
                prezime = scanner.nextLine();
                if (prezime.isEmpty()) {
                    throw new EmptyNameOrSurnameException("Prezime ne može biti prazno!");
                }
            } catch (EmptyNameOrSurnameException e) {
                System.out.println(e.getMessage());
                continue;
            }
            boolean validSalary = false;
            while (!validSalary) {
                try {
                    System.out.println("Unesi plaću zaposlenika: ");
                    placa = scanner.nextDouble();
                    scanner.nextLine();

                    if (placa <= 0) {
                        if (placa == 0) {
                            throw new InvalidSalaryException("Plaća ne može biti 0!");
                        } else {
                            throw new InvalidSalaryException("Plaća mora biti veća od nule!");
                        }
                    }
                    validSalary = true;
                } catch (InvalidSalaryException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Unesite ispravan broj za plaću.");
                }
            }

            Zaposlenik zaposlenik = new Zaposlenik(ime, prezime, placa);
            tvrtka.dodajZaposlenika(zaposlenik);
        }
        tvrtka.ispisiZaposlenike();
        System.out.println("Zaposlenik " + tvrtka.pronadjiNajvecuPlacu().getIme() + " " + tvrtka.pronadjiNajvecuPlacu().getPrezime() + " ima najveću plaću: " + tvrtka.pronadjiNajvecuPlacu().getPlaca() + " eura.");
    }
}