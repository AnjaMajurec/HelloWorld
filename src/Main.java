import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //4. Popis knjiga
        //Napravite klasu Knjiga koja ima sljedeće atribute:
        //Naslov, autor i godina izdanja.
        //Napravite listu knjiga i dodajte nekoliko knjiga ručno. Zatim implementirajte metodu koja:
        //Ispisuje sve knjige autora kojeg unese korisnik.
        Scanner scanner = new Scanner(System.in);
        List<Knjiga> knjige = new ArrayList<>();
        Knjiga knjiga1 = new Knjiga("Okus: Toskana", "Stanley Tucci", "2018");
        knjige.add(knjiga1);
        Knjiga knjiga2 = new Knjiga("Okus: Sicilija", "Stanley Tucci", "2019");
        knjige.add(knjiga2);
        Knjiga knjiga3 = new Knjiga("Potresi", "Hrvoje Tkalčić", "2020");
        knjige.add(knjiga3);

        System.out.println("Upisite ime autora cije knjige želite ispisati: ");
        String unos = scanner.nextLine();
        ispisKnjigaUnesenogAutora(knjige,unos);

    }
        public static void ispisKnjigaUnesenogAutora(List <Knjiga> knjige, String unos){
                boolean postojiKnjiga=false;
                for(Knjiga knjiga:knjige){
                    if(knjiga.getAutor().equalsIgnoreCase(unos)){
                        System.out.println(knjiga.toString());
                        postojiKnjiga=true;
                    }
                }
                if(!postojiKnjiga){
                    System.out.println("Ne postoji ni jedna knjiga unesenog autora.");
                }
        }
}