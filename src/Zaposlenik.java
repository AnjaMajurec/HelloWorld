//Napravite klasu Zaposlenik koja sadrži sljedeće podatke: ime(tipa String)-ime zaposlenika, prezime(tipa String)-prezime zaposlenika,
//placa(tipa double), napravite konstruktor za inicijalizaciju svih atributa. Napravite metodu toString() za formatirani ispis informacija
//o zaposleniku.

public class Zaposlenik {
    private final String ime;
    private final String prezime;
    private double placa;

    public Zaposlenik(String ime, String prezime, double placa) {
        this.ime = ime;
        this.prezime=prezime;
        this.placa=placa;
    }

    public String getIme() {
        return this.ime;
    }
    public String getPrezime(){
        return this.prezime;
    }
    public double getPlaca(){
        return this.placa;
    }
    public void setPlaca(double placa){
        this.placa=placa;
    }
    public String toString() {
        return "Zaposlenik, ime: "+this.ime+", prezime: "+this.prezime+", plaća: "+this.placa;
    }
}
