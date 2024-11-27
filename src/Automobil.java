public class Automobil extends Vozilo{
    private Integer brojVrata;
    public Automobil(String registrskiBrojVozila, String markaVozila, Integer godinaProizvodnjeVozila, Integer brojVrata) throws NeispravniPodaciException {
        super(registrskiBrojVozila, markaVozila,godinaProizvodnjeVozila);
        if(brojVrata<=0){
            throw new NeispravniPodaciException("Broj vrata ne može biti manji ili jednak nuli.");
        }
        this.brojVrata=brojVrata;
    }
    public Integer getBrojVrata(){
        return brojVrata;
    }
    public void setBrojVrata(Integer brojVrata){
        this.brojVrata=brojVrata;
    }
    @Override
    public String prikaziPodatke(){
        return getRegistarskiBrojVozila()+", "+getMarkaVozila()+", "+getGodinaProizvodnjeVozila()+", "+getBrojVrata();
    }
}
