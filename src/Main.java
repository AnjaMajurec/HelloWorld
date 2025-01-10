import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> rijecBrojPonavljanja = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite rečenicu: ");
        String recenica = scanner.nextLine();

        String[] rijeci = recenica.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for (String rijec : rijeci) {
            rijecBrojPonavljanja.put(rijec, rijecBrojPonavljanja.getOrDefault(rijec,0)+1);
        }

        System.out.println("Broj ponavljanja svake riječi: ");
        System.out.println(rijecBrojPonavljanja);
    }
}







