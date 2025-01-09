public class Polaznik {


    private final String ime;
    private final String prezime;
    private final String email;


    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public String getEmail() {
        return this.email;
    }


    @Override
    public String toString() {
        return this.ime + " " + this.prezime + " " + this.email;
    }
}
