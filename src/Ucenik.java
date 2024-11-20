public class Ucenik {

    private String ime;
    private String prezime;
    private Double prosjek;

    public Ucenik(String ime, String prezime, Double prosjek) {
        this.ime = ime;
        this.prezime = prezime;
        this.prosjek=prosjek;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public Double getProsjek(){
        return this.prosjek;
    }
    public void setProsjek(Double prosjek){
        this.prosjek=prosjek;
    }

    @Override
    public String toString() {
        return "Zovem se: " + this.ime + " " + this.prezime;
    }

    public void ispisiInfo() {
        System.out.println("Zovem se: " + this.ime + " " + this.prezime+" prosjek "+this.prosjek);
    }
}