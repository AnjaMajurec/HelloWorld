import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studenti = new ArrayList<>();
        do{
            System.out.println("Unesi ime studenta (ili unesi 0 za kraj unosa): ");
            String imeStudenta= scanner.nextLine();
            if (imeStudenta.equals("0")){
                break;
            }
            System.out.println("Unesi prezime studenta: ");
            String prezimeStudenta= scanner.nextLine();
            System.out.println("Unesi broj indeksa: ");
            String brojIndeksaStudenta=scanner.nextLine();
            System.out.println("Unesi prosjek studenta: ");
            Double prosjekOcjenaStudenta= scanner.nextDouble();
            scanner.nextLine();


            Student student = new Student(imeStudenta, prezimeStudenta, brojIndeksaStudenta, prosjekOcjenaStudenta);
            studenti.add(student);
            System.out.println("Unos novog studenta uspješan.");
        }while(true);
        System.out.println("Popis svih studenata: ");
        for(Student student: studenti){
            System.out.println(student.getIme()+" "+ student.getPrezime()+", broj indeksa: "+student.getBrojIndeksa()+", prosjek ocjena: "+student.getProsjekOcjena());
        }
        najvisiProsjek(studenti);
        najniziProsjek(studenti);
        prosjekSvihStudenata(studenti);
    }
    public static void najvisiProsjek(ArrayList<Student> studenti){
        Double maxProsjekStudent=1.0;
        for(Student student:studenti){
            if (student.getProsjekOcjena()>=maxProsjekStudent){
                maxProsjekStudent=student.getProsjekOcjena();
            }
        }
        System.out.print("Student/i s najvišim prosjekom "+maxProsjekStudent+" je/su: ");
        for(Student student:studenti){
            if (student.getProsjekOcjena().equals(maxProsjekStudent)){
                System.out.print(student.getIme()+" "+student.getPrezime()+", ");
            }
        }
    }
    public static void najniziProsjek(ArrayList<Student> studenti){
        Double minProsjekStudent=5.0;
        for(Student student:studenti){
            if (student.getProsjekOcjena()<=minProsjekStudent){
                minProsjekStudent=student.getProsjekOcjena();
            }
        }
        System.out.println();
        System.out.print("Student/i s najnižim prosjekom "+minProsjekStudent+" je/su: ");
        for(Student student:studenti){
            if (student.getProsjekOcjena().equals(minProsjekStudent)){
                System.out.print(student.getIme()+" "+student.getPrezime()+", ");
            }
        }
    }
    public static void prosjekSvihStudenata(ArrayList<Student> studenti){
        Double zbroj=Double.valueOf(0);
        System.out.println();
        for(Student student:studenti){
            zbroj+=student.getProsjekOcjena();
        }
        System.out.println("Prosjek svih studenata je: "+zbroj/studenti.size());
    }
}

