import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Napravite program za upravljanje informacijama o proizvodima u trgovini. Program treba omogućiti:
    //Definiranje klase Proizvod koja ima sljedeće atribute:
    //naziv (tipa String) - naziv proizvoda,
    //cijena (tipa double) - cijena proizvoda,
    //kolicina (tipa int) - dostupna količina proizvoda.
    //Dodavanje metoda u klasu Proizvod:
    //Konstruktor koji prima sve atribute.
    //Metodu String toString() koja vraća formatirani tekst s informacijama o proizvodu.
    //Kreiranje glavnog programa:
    //Napravite listu proizvoda (npr. List<Proizvod>).
    //Dodajte barem pet proizvoda u listu pomoću korisničkog unosa preko konzole.
    //Prikaz svih proizvoda na ekranu.
    //Zapisivanje u datoteku:
    //Sve proizvode iz liste zapišite u datoteku pod nazivom proizvodi.txt.
    //Dodajte dodatne informacije u datoteku, poput naslova i razdjelnika između proizvoda.
    //Filtrirajte proizvode skuplje od određene cijene (npr. 50.0) i spremite samo njih u drugu datoteku pod nazivom skupljiProizvodi.txt.

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Proizvod> proizvodi = new ArrayList<>();
        System.out.println("Koliko proizvoda želite unijeti u listu?");
        int brojProizvoda = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < brojProizvoda; i++) {
            System.out.println("Unesi naziv " + (i + 1) + ". proizvoda: ");
            String naziv = scanner.nextLine();
            System.out.println("Unesi cijenu " + (i + 1) + ". proizvoda: ");
            Double cijena = scanner.nextDouble();
            System.out.println("Unesi kolicinu " + (i + 1) + ". proizvoda: ");
            Integer kolicina = scanner.nextInt();
            proizvodi.add(new Proizvod(naziv, cijena, kolicina));
            scanner.nextLine();
        }
        System.out.println("Lista proizvoda: ");
        for (Proizvod proizvod : proizvodi) {
            System.out.println(proizvod);

        }
        Double granicaCijeneProizvoda = 50.5;

        Writer proizvodiOut = new FileWriter("proizvodi.txt");
        String nazivDatoteke = "skupljiProizvodiOd" + granicaCijeneProizvoda + ".txt";
        Writer skupljiProizvodiOut = new FileWriter(nazivDatoteke);


        zapisProizvodaUDatoteku(proizvodi, proizvodiOut);
        List<Proizvod> skupljiProizvodi = filtrirajProizvode(proizvodi, granicaCijeneProizvoda); //2. ulazni paramaetar je granica cijene proizvoda
        zapisProizvodaUDatoteku(skupljiProizvodi, skupljiProizvodiOut);


    }

    public static void zapisProizvodaUDatoteku(List<Proizvod> proizvodi, Writer izlaznaDatoteka) throws IOException {

        izlaznaDatoteka.write("Popis proizvoda:\n");
        izlaznaDatoteka.write("=================================\n");


        for (Proizvod proizvod : proizvodi) {
            izlaznaDatoteka.write(proizvod.toString() + "\n");
            izlaznaDatoteka.write("---------------------------------\n");
        }
        izlaznaDatoteka.close();
    }

    public static List<Proizvod> filtrirajProizvode(List<Proizvod> proizvodi, double granicaCijeneProizvoda) {
        List<Proizvod> skupljiProizvodi = new ArrayList<>();
        for (Proizvod proizvod : proizvodi) {
            if (proizvod.getCijena() > granicaCijeneProizvoda) {
                skupljiProizvodi.add(proizvod);
            }
        }
        return skupljiProizvodi;
    }
}