import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //5. Popis studenata
        //Napravite klasu Student s atributima:
        //Ime, prezime i prosjek ocjena.
        //Stvorite listu studenata i dodajte nekoliko objekata u listu. Zatim:
        //Pronađite i ispišite podatke o studentu s najvećim prosjekom.
        Scanner scanner = new Scanner(System.in);
        List <Student> studenti=new ArrayList<>();
        studenti.add(new Student("Anja","Majurec",4.56));
        studenti.add(new Student("Iva","Foret",3.45));
        studenti.add(new Student("Lara","Mandić",4.9));
        studentSNajvecimProsjekom(studenti);
        
    }
    public static void studentSNajvecimProsjekom(List<Student> studenti){
        Student najboljiStudent=studenti.get(0);
        for (Student student : studenti) {
            if(student.getProsjekOcjena()>najboljiStudent.getProsjekOcjena()){
                najboljiStudent=student;

            }
        }
        System.out.println("Student s najvećim prosjekom: " + najboljiStudent.getIme()+" "+najboljiStudent.getPrezime()+", prosjek: "+najboljiStudent.getProsjekOcjena());
    }
}