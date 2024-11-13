import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Zaposlenik {
    private final String ime;
    private final Integer brojRadnihSati;
    private BigDecimal osnovnaPlaca;

    public Zaposlenik(String ime, BigDecimal osnovnaPlaca, Integer brojRadnihSati) {
        this.ime = ime;
        this.osnovnaPlaca = osnovnaPlaca;
        this.brojRadnihSati = brojRadnihSati;
    }

    public String getIme() {
        return this.ime;
    }

    public BigDecimal getOsnovnaPlaca() {
        return osnovnaPlaca;
    }

    public void setOsnovnaPlaca(BigDecimal osnovnaPlaca) {
        this.osnovnaPlaca = osnovnaPlaca;
    }

    public Integer getBrojRadnihSati() {
        return brojRadnihSati;
    }

    public abstract BigDecimal izracunPlace();

    public void ispisPodataka() {
        System.out.println("Ime: " + ime + ", osnovna plaća: " + osnovnaPlaca.setScale(2, RoundingMode.HALF_UP) + ", broj radnih sati: " + brojRadnihSati + ", ukupna plaća: " + izracunPlace().setScale(2, RoundingMode.HALF_UP) + ".");

    }
}
