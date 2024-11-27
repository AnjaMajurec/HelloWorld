public class Motocikl extends Vozilo{
    private String tipMotora;
    public Motocikl(String registarskiBrojVozila, String markaVozila, Integer godinaProizvodnjeVozila, String tipMotora) throws NeispravniPodaciException {
        super(registarskiBrojVozila, markaVozila, godinaProizvodnjeVozila);
        this.tipMotora=tipMotora;
    }
    public String getTipMotora(){
        return tipMotora;
    }
    public void setTipMotora(String tipMotora){
        this.tipMotora=tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return getRegistarskiBrojVozila()+", "+getMarkaVozila()+", "+getGodinaProizvodnjeVozila()+", "+getTipMotora();
    }
}
