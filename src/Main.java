import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Prvi zadatak
    // Statistika riječi Napravi program koji učitava rečenicu i ispisuje:
    // 1. Sve riječi duže od 5 slova, 2. Najdužu riječ, 3.Prosječnu duljinu riječi.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite željenu rečenicu: ");
        String recenica = scanner.nextLine();

        String[] rijeci = recenica.split(" ");

        List<String> lista = new ArrayList<>();
        for (String s : rijeci) {
            lista.add(s);
        }
        petSlova(lista);
        najduzaRijec(lista);
        System.out.println("Prosječna duljina riječi je: " + prosjecnaDuljinaRijeci(lista));

    }
    public static void petSlova(List<String> lista){
        System.out.print("Riječi koje imaju više od 5 slova: ");
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).length()>5){
                System.out.print(lista.get(i)+" ");
            }
        }
        System.out.println();
    }
    public static void najduzaRijec (List<String> lista){
        String rijecMax=" ";
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).length()>rijecMax.length()){
                rijecMax=lista.get(i);
            }
        }
        //ako imamo više riječi koje imaju isto slova ko najduža riječ
        System.out.print("Najduža riječ je: ");
        for(int i=0;i<lista.size();i++) {
            if (lista.get(i).length() == rijecMax.length()) {
                System.out.print(lista.get(i)+" ");
            }
        }
        System.out.println();
    }

    public static Integer prosjecnaDuljinaRijeci (List<String> lista){
        int ukupnaDuljina=0;
        for(int i=0;i<lista.size();i++){
            ukupnaDuljina+=lista.get(i).length();
        }
        return ukupnaDuljina/lista.size();
    }
}