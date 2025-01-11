public class Proizvod {
    private final String naziv;

    public Proizvod(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return this.naziv;
    }
    @Override
    public String toString() {
        return naziv;
    }
}

