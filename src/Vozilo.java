public abstract class Vozilo {
    private String markaVozila;
    private String modelVozila;
    private String registracijaVozila;

    public Vozilo(String markaVozila, String modelVozila, String registracijaVozila){
        this.markaVozila=markaVozila;
        this.modelVozila=modelVozila;
        this.registracijaVozila=registracijaVozila;
    }
    public void detaljanOpisVozila(){
    }
    public String getMarkaVozila(){
        return markaVozila;
    }
    public String getModelVozila(){
        return modelVozila;
    }
    public String getRegistracijaVozila(){
        return registracijaVozila;
    }

}
