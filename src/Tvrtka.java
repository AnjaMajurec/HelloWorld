//Napravite klasu Tvrtka koja sadrži sljedeće: atribut zaposlenici (tipa List <Zaposlenik>) koji čuva listu zaposlenika,
//metodu dodajZaposlenika(Zaposlenik zaposlenik) za dodavanje novog zaposlenika u listu.
//matodu ispisZaposlenika() za ispis svih zaposlenika u tvrtki.
//matodu pronadjiNajvecuPlacu() za pronalazenja zaposlenika s najvećom plaćom.

import java.util.List;
import java.util.ArrayList;

public class Tvrtka {
    private String imeTvrtke;
    private List<Zaposlenik> zaposlenici;

    public Tvrtka(String imeTvrtke){
        this.imeTvrtke=imeTvrtke;
        this.zaposlenici = new ArrayList<>();

    }

    public String getImeTvrtke(){
        return this.imeTvrtke;
    }
    public void setImeTvrtke(String imeTvrtke){
        this.imeTvrtke=imeTvrtke;
    }
    public List <Zaposlenik> getZaposlenici(){
        return this.zaposlenici;
    }
    public void setZaposlenici(List <Zaposlenik> zaposlenici){
        this.zaposlenici=zaposlenici;
    }
    public void dodajZaposlenika(Zaposlenik zaposlenik){
        this.zaposlenici.add(zaposlenik);
    }
    public void ispisiZaposlenike(){
        System.out.println("SVI ZAPOSLENICI:");
        for(Zaposlenik zaposlenik: zaposlenici) {
            System.out.println(zaposlenik.toString());
        }
    }
    public Zaposlenik pronadjiNajvecuPlacu(){
        double najvecaPlaca=0.00;
        Zaposlenik zaposlenikSNajvecomPlacom=null;
        for(Zaposlenik zaposlenik: zaposlenici){
            double placa=zaposlenik.getPlaca();
            if(placa>najvecaPlaca){
                zaposlenikSNajvecomPlacom=zaposlenik;
                najvecaPlaca=placa;
            }

        }
        return zaposlenikSNajvecomPlacom;
    }

}
