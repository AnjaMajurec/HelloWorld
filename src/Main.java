import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TekuciRacun tekuciRacun = new TekuciRacun("HR12345", BigDecimal.valueOf(100), "Anja Majurec");
        StedniRacun stedniRacun = new StedniRacun("HR54321", BigDecimal.valueOf(200), "Iva Foret");

        System.out.println("TEKUĆI RAČUN");
        tekuciRacun.uplata(BigDecimal.valueOf(100));
        tekuciRacun.isplata(BigDecimal.valueOf(10));
        tekuciRacun.obracunKamate();


        System.out.println("ŠTEDNI RAČUN");

        stedniRacun.uplata(BigDecimal.valueOf(23.23));
        stedniRacun.isplata(BigDecimal.valueOf(54.21));
        stedniRacun.obracunKamate();
    }

}