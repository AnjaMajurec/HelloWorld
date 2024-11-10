import java.math.BigDecimal;
import java.math.RoundingMode;

public class Proizvod {
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal popust;


    public Proizvod(String nazivProizvoda, BigDecimal cijenaProizvoda){
        this.naziv=nazivProizvoda;
        this.cijena=cijenaProizvoda;
    }
    public void postaviPopust(BigDecimal unosPopusta){
        this.popust=unosPopusta;
    }
    public BigDecimal izracunajCijenu(){
        BigDecimal novaCijena=cijena.multiply(BigDecimal.valueOf(1).subtract(popust.divide(BigDecimal.valueOf(100),4, RoundingMode.HALF_UP)));

        return novaCijena;
    }

}
