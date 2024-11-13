import java.math.BigDecimal;

public class StalniZaposlenik extends Zaposlenik {
    public StalniZaposlenik(String ime, BigDecimal osnovnaPlaca, Integer brojRadnihSati) {
        super(ime, osnovnaPlaca, brojRadnihSati);
    }

    @Override
    public BigDecimal izracunPlace() {
        BigDecimal ukupnaPlaca = getOsnovnaPlaca();
        if (getBrojRadnihSati() > 160) {
            ukupnaPlaca = ukupnaPlaca.add(getOsnovnaPlaca().multiply(BigDecimal.valueOf(0.15)));
        }
        return ukupnaPlaca;
    }
}