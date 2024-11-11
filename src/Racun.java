import java.math.BigDecimal;

public class Racun {
    private final String brojRacuna;
    private final String vlasnik;
    private BigDecimal stanje;

    public Racun(String brojRacuna, BigDecimal stanje, String vlasnik) {
        this.brojRacuna = brojRacuna;
        this.stanje = stanje;
        this.vlasnik = vlasnik;
    }

    public BigDecimal getStanje() {
        return stanje;
    }

    public void setStanje(BigDecimal novoStanje) {
        this.stanje = novoStanje;
    }

    public void obracunKamate() {

    }

    public void uplata(BigDecimal iznos) {
        stanje = stanje.add(iznos);
        System.out.println("Uplaćeno je: " + iznos + " eura na račun.");
    }

    public void isplata(BigDecimal iznos) {
        System.out.println("S računa je isplaćeno: " + iznos + " eura.");
        stanje = stanje.subtract(iznos);

    }
}
