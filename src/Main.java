import java.io.*;

public class Main {
    //Napravite klasu student sa osnovnim informacijama (ime,prezime,brIndexa).
    //Napravite 3 studenta unutar maina, te zapisite sve informacije o svakom studentu u datoteku
    //koja se naziva studenti.txt
    //ispisite podatke u datoteku da bude sve pregledno i citljivo.
    //Nakon upisa podataka u datoteku, na kraju prebrojite koliko je slova zapisano u datoteci te
    //ispiste tu informaciju korisniku.

    public static void main(String[] args) throws IOException {
        Student student1 = new Student("Anja", "Majurec", "123456");
        Student student2 = new Student("Iva", "Foret", "654321");
        Student student3 = new Student("Lara", "Mandić", "451263");


        Writer out = new FileWriter( "studenti.txt");
        PrintWriter easyOut = new PrintWriter( out );
        for(int i=0;i<3;i++){
            easyOut.println(student1.ispisStudenta());
            easyOut.println(student2.ispisStudenta());
            easyOut.println(student3.ispisStudenta());
            easyOut.close();
        }

        FileReader in = new FileReader("studenti.txt");
        int brojZnakova = 0;
        int c;

        while ((c = in.read()) != -1) {
            brojZnakova++;
        }
        in.close();
        System.out.println("Broj znakova u datoteci 'studenti.txt' je: " + brojZnakova);
    }
}