import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Polaznik polaznik1=new Polaznik("Anja", "Majurec");
        Polaznik polaznik2=new Polaznik("Ivor", "Stojevski",27,"m");
        Polaznik polaznik3=new Polaznik();

        System.out.println("Polaznik 1. je: "+polaznik1.dohvatiIme()+" "+polaznik1.dohvatiPrezime());
        polaznik2.promijeniDob(30);

        System.out.println("Unesi ime trećeg polaznika: ");
        String novoIme=scanner.nextLine();
        polaznik3.dodajIme(novoIme);

        System.out.println("Unesi prezime trećeg polaznika: ");
        String novoPrezime=scanner.nextLine();
        polaznik3.dodajPrezime(novoPrezime);
    }
}

