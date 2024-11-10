public class Main {
    public static void main(String[] args) {
        Student student1=new Student("Anja", "Majurec", "1234", 4.5);
        Student student2=student1;

        student1.promjeniProsjekOcjena(5.0);
        System.out.println("Prosjek studenta 1 je "+student1.getProsjekOcjena());
        System.out.println("Prosjek studenta 2 je "+student2.getProsjekOcjena());

        //klase su referentni tipovi, spremaju adresu gdje se nešto nalazi, student2 ima istu adresu kao i student1
        //obje varijable pokazuju na iste vrijednosti, jednom je pozvan new Student
    }
}
