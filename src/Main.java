import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Napravite program za upravljanje sustavom knjižnice. Program treba sadržavati:
        //Klase za osobe – Program treba imati klase koje predstavljaju osobe u sustavu,
        //poput člana knjižnice, s pripadajućim podacima (ime, prezime, članski broj).
        //Sučelje za rad s knjigama – Treba definirati sučelje koje će omogućiti rad s knjigama (npr. dodavanje i vraćanje knjiga).
        //Klasa knjižnice – Klasa koja sadrži:
        //listu svih članova knjižnice,
        //listu svih knjiga dostupnih u knjižnici,
        //metode za upravljanje članovima i knjigama.
        //Pisanje u datoteku – Podaci o članovima, njihovim posuđenim knjigama i stanju knjiga u knjižnici
        //moraju se zapisivati u datoteku na kraju programa.
        //Osnovni podaci o članovima knjižnice:
        //Omogućiti unos korisnika (ime, prezime, članski broj) putem konzole.
        //Rad s knjigama:
        //Klasa knjižnice treba sadržavati listu svih knjiga dostupnih za posudbu.
        //Omogućiti svakom članu knjižnice da posuđuje i vraća knjige.
        //Kada član posudi knjigu:
        //Knjiga se treba ukloniti iz liste knjiga u knjižnici.
        //Knjiga se treba dodati u listu knjiga posuđenih od strane člana.
        //Kada član vrati knjigu:
        //Knjiga se uklanja iz liste posuđenih knjiga kod člana.
        //Knjiga se ponovno dodaje u listu knjiga knjižnice.
        //3. Rad s datotekom: Na kraju programa ispisati informacije o tvrtci (informacije o clanovima i knjigama takoder)
        //unutar datoteke tvrtka.txt.
        //Istu stvar napraviti i za clanove, ispisati podatke o clanovima (ime, prezime, knjige....) u datoteku clanovi.txt
        //4. Korištenje nasljeđivanja i sučelja:
        //Koristiti nasljeđivanje za kreiranje hijerarhije klasa.
        //Implementirati sučelje koje definira metode za dodavanje i vraćanje knjiga.
        Scanner scanner = new Scanner(System.in);
        Knjiznica knjiznica = new Knjiznica();
        System.out.println("Koliko članova želite unijeti: ");
        int brojClanova = scanner.nextInt();
        scanner.nextLine();
        Clan[] clanovi=new Clan[brojClanova];
        for (int i = 0; i < brojClanova; i++) {
            System.out.println("Unesite ime člana: ");
            String ime = scanner.nextLine();
            System.out.println("Unesite prezime člana: ");
            String prezime = scanner.nextLine();
            System.out.println("Unesite članski broj: ");
            String clanskiBroj = scanner.nextLine();
            clanovi[i]= new Clan(ime, prezime, clanskiBroj);
            knjiznica.dodajClana(clanovi[i]);
        }
        knjiznica.dodajKnjigu(new Knjiga("Idemo na more", "Rene Freund", "4321"));
        knjiznica.dodajKnjigu((new Knjiga("Okus", "Stanley Tucci", "2315")));
        knjiznica.dodajKnjigu(new Knjiga("Svjetla juga", "Nina George", "7643"));
        knjiznica.dodajKnjigu(new Knjiga("Normalni ljudi", "Sally Rooney", "9943"));
        knjiznica.dodajKnjigu(new Knjiga("Potresi", "Hrvoje Tkalčić", "5432"));
        int izbor=0;
        Clan korisnik=null;
        do {
            System.out.println("Unesite članski broj člana kojeg želite odabrati: (ili za izlaz 0)");
            String clanskiBroj = scanner.nextLine();
            if(clanskiBroj.equals("0")) {
                System.out.println("Izašli ste iz knjižnice.");
                break;
            }


            korisnik = knjiznica.nadjiClanaPoClanskomBroju(clanskiBroj);

            if (korisnik == null) {
                System.out.println("Član s tim članskim brojem nije pronađen.");
                continue;
            }
            System.out.println("1-posudi knjigu, 2-vrati knjigu, 3-izlaz");
            izbor = scanner.nextInt();
            scanner.nextLine();
            switch (izbor) {
                case 1:
                    posudba(knjiznica,korisnik,scanner);
                    break;
                case 2:
                    vracanje(knjiznica,korisnik,scanner);
                    break;
                default:
                    System.out.println("Neispravan unos, pokušajte ponovno.");

            }
        } while (izbor != 4);
        knjiznica.spremiPodatkeUDatoteku();

    }
    private static void posudba(Knjiznica knjiznica,Clan clan,Scanner scanner){
        System.out.println("Unesite naslov knjige koju želite posuditi:");
        String naziv=scanner.nextLine();
        Knjiga knjigaZaPosudbu=null;
        for(Knjiga knjiga:knjiznica.getKnjige()){
            if(knjiga.getNaziv().equalsIgnoreCase(naziv)){
                knjigaZaPosudbu=knjiga;
                break;
            }
        }
        if(knjigaZaPosudbu!=null){
            knjiznica.posudiKnjigu(clan,knjigaZaPosudbu);
            System.out.println("Knjiga posuđena "+knjigaZaPosudbu);

        }
        else{
            System.out.println("Knjiga nije pronađena ili nije dostupna.");
        }
    }
    private static void vracanje(Knjiznica knjiznica, Clan clan, Scanner scanner){
        System.out.print("Unesite naziv knjige koju želite vratiti: ");
        String naziv = scanner.nextLine();
        Knjiga knjigaZaVratiti = null;

        for (Knjiga knjiga : clan.getPosudeneKnjige()) {
            if (knjiga.getNaziv().equalsIgnoreCase(naziv)) {
                knjigaZaVratiti = knjiga;
                break;
            }
        }

        if (knjigaZaVratiti != null) {
            knjiznica.vratiKnjigu(clan, knjigaZaVratiti);
            System.out.println("Knjiga vraćena: " + knjigaZaVratiti);
        } else {
            System.out.println("Niste posudili tu knjigu.");
        }
    }

}