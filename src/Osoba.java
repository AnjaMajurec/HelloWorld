public class Osoba {
    private String ime;
    private String prezime;
    private String datumRodenja;

    public Osoba(String ime, String prezime, String datumRođenja){
        this.ime=ime;
        this.prezime=prezime;
        this.datumRodenja=datumRođenja;
    }

    public String getIme(){
        return ime;
    }
    public String getPrezime(){
        return prezime;
    }
    public String getDatumRodenja(){
        return datumRodenja;
    }
}
