import java.math.BigDecimal;

public class StedniRacun extends Racun {
    private final BigDecimal kamatnaStopa = BigDecimal.valueOf(0.015);

    public StedniRacun(String brojRacuna, BigDecimal stanje, String vlasnik) {
        super(brojRacuna, stanje, vlasnik);

    }

    @Override
    public void obracunKamate() {
        BigDecimal kamata = getStanje().multiply(kamatnaStopa);
        BigDecimal novoStanje = getStanje().add(kamata);
        setStanje(novoStanje);
        System.out.println("Novo stanje štednog računa iznosi: " + novoStanje + " s kamatom od " + kamata);
    }

}
