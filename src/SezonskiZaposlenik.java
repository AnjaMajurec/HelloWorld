import java.math.BigDecimal;


public class SezonskiZaposlenik extends Zaposlenik {

    public SezonskiZaposlenik(String ime, BigDecimal osnovnaPlaca, Integer brojRadnihSati) {
        super(ime, osnovnaPlaca, brojRadnihSati);
    }

    @Override
    public BigDecimal izracunPlace() {
        BigDecimal ukupnaPlaca = getOsnovnaPlaca();
        if (getBrojRadnihSati() > 200) {
            ukupnaPlaca = ukupnaPlaca.add(getOsnovnaPlaca().multiply(BigDecimal.valueOf(0.10)));
        }
        return ukupnaPlaca;
    }
}

