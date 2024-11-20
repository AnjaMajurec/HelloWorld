public class Main {
    public static void main(String[] args) {
        Razred razred = new Razred("1B", "Petar");

        Ucenik ucenik1 = new Ucenik("Ana", "Anic", 5.0);
        razred.dodajUcenika(ucenik1);

        Ucenik ucenik2 = new Ucenik("Ivan", "Ivic", 3.42);
        razred.dodajUcenika(ucenik2);

        for (Ucenik ucenik : razred.getUcenici()) {
            ucenik.ispisiInfo();
        }
        System.out.println("Najbolji učenik je "+razred.najboljiUcenik().getIme()+" "+razred.najboljiUcenik().getPrezime()+" s prosjekom "+razred.najboljiUcenik().getProsjek()+".");
    }
}