public class Proizvod {
    private final String naziv;
    private final Double cijena;
    private final Integer kolicina;

    public Proizvod(String naziv, Double cijena, Integer kolicina) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Double getCijena() {
        return this.cijena;
    }

    public Integer getKolicina() {
        return this.kolicina;
    }

    public String toString() {
        return naziv + ", cijena: " + cijena + ", kolicina: " + kolicina;
    }
}

