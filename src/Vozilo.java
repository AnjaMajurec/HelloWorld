public abstract class Vozilo {
    private String registarskiBrojVozila;
    private String markaVozila;
    private Integer godinaProizvodnjeVozila;

    public Vozilo(String registarskiBrojVozila, String markaVozila, Integer godinaProizvodnjeVozila) throws NeispravniPodaciException {
        if (godinaProizvodnjeVozila<=0){
            throw new NeispravniPodaciException("Godina proizvodnje ne može biti manja ili jednaka nuli.");
        }
        this.registarskiBrojVozila=registarskiBrojVozila;
        this.markaVozila=markaVozila;
        this.godinaProizvodnjeVozila=godinaProizvodnjeVozila;
    }
    public abstract String prikaziPodatke();

    public String getRegistarskiBrojVozila(){
        return registarskiBrojVozila;
    }
    public String getMarkaVozila(){
        return markaVozila;
    }
    public Integer getGodinaProizvodnjeVozila(){
        return godinaProizvodnjeVozila;
    }
    public void setRegistarskiBrojVozila(String registarskiBrojVozila){
        this.registarskiBrojVozila=registarskiBrojVozila;
    }

    public void setMarkaVozila(String markaVozila) {
        this.markaVozila = markaVozila;
    }

    public void setGodinaProizvodnjeVozila(Integer godinaProizvodnjeVozila) {
        this.godinaProizvodnjeVozila = godinaProizvodnjeVozila;
    }
}
