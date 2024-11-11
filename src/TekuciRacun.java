import java.math.BigDecimal;

public class TekuciRacun extends Racun {
    private final BigDecimal kamatnaStopa = BigDecimal.valueOf(0.001);

    public TekuciRacun(String brojRacuna, BigDecimal stanje, String vlasnik) {
        super(brojRacuna, stanje, vlasnik);

    }

    @Override
    public void obracunKamate() {
        BigDecimal kamata = getStanje().multiply(kamatnaStopa);
        BigDecimal novoStanje = getStanje().add(kamata);
        setStanje(novoStanje);

        System.out.println("Novo stanje tekućeg računa iznosi: " + novoStanje + " s kamatom od " + kamata);
    }

}

