import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> rijecBrojPonavljanja = new HashMap<>();
        HashSet<String> jedinstveniBrojevi = new HashSet<>();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite brojeve odvojene zarezom: ");
        String unosBrojeva = scanner.nextLine();

        String[] brojevi = unosBrojeva.split("\\s+");
        for (String broj : brojevi) {
            jedinstveniBrojevi.add(broj);
        }

        System.out.println("Jedinstveni brojevi: ");
        System.out.println(jedinstveniBrojevi);

        int minBroj=Integer.MAX_VALUE;
        int maxBroj=Integer.MIN_VALUE;

        for (String s : jedinstveniBrojevi) {
            int provjeraBroja=Integer.parseInt(s);
            if(provjeraBroja<minBroj){
                minBroj=provjeraBroja;
            }
            if(provjeraBroja>maxBroj){
                maxBroj=provjeraBroja;
            }
        }
        System.out.println("Najmanji broj je: "+minBroj);
        System.out.println("Najveći broj je: "+maxBroj);

    }
}







