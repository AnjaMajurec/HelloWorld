public class Polaznik {
    private String ime;
    private String prezime;
    private Integer dob;
    private String spol;

    public Polaznik(String imePolaznika, String prezimePolaznika){
        this.ime=imePolaznika;
        this.prezime=prezimePolaznika;
    }

    public Polaznik(String imePolaznika, String prezimePolaznika, Integer dobPolaznika, String spolPolaznika){
        this.ime=imePolaznika;
        this.prezime=prezimePolaznika;
        this.dob=dobPolaznika;
        this.spol=spolPolaznika;
    }
    public Polaznik(){
    }

    public String dohvatiIme(){
        return this.ime;
    }
    public String dohvatiPrezime(){
        return this.prezime;
    }
    public void promijeniDob(Integer noviUnosGodine){
        this.dob=noviUnosGodine;
    }
    public void dodajIme(String novoIme){
        this.ime=novoIme;
    }
    public void dodajPrezime(String novoPrezime){
        this.prezime=novoPrezime;
    }

}
