import java.time.Year;

public class abstractKnjiga implements Knjiga {
    private final String naslov;
    private final String autor;
    private String stanje;
    private Integer godinaIzdavanja;
    private Integer brojStranica;

    public abstractKnjiga(String naslov, String autor, Integer godinaIzdavanja, Integer brojStranica) {
        this.naslov = naslov;
        this.autor = autor;
        if (godinaIzdavanja > 1900 && godinaIzdavanja <= Year.now().getValue()) {
            this.godinaIzdavanja = godinaIzdavanja;
        } else {
            System.out.println("Godina izdavanja knjige mora biti između 1900. godine i trenutne godine.");
        }
        if (brojStranica > 0) {
            this.brojStranica = brojStranica;
        } else {
            System.out.println("Krivi unos broja stranica.");
        }

        this.stanje = "Dostupno";
    }

    public String getNaslov() {
        return naslov;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getGodinaIzdavanja() {
        return godinaIzdavanja;
    }


    public Integer getBrojStranica() {
        return brojStranica;
    }

    public String getStanje() {
        return stanje;
    }

    public void posudi() {
        if (stanje.equals("Dostupno")) {
            this.stanje = "Posuđeno";
        } else {
            System.out.println("Knjiga je već posuđena.");
        }
    }

    public void vratiti() {
        if (stanje.equals("Posuđeno")) {
            this.stanje = "Dostupno";
        } else {
            System.out.println("Knjiga je dostupna.");
        }
    }
}
