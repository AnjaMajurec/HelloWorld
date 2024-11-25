public class Auto extends Vozilo {
    private Integer brojSjedala;
    private String vrstaGoriva;

    public Auto(String markaVozila, String modelVozila, String registracijaVozila, Integer brojSjedala, String vrstaGoriva){
        super(markaVozila, modelVozila, registracijaVozila);
        this.brojSjedala=brojSjedala;
        this.vrstaGoriva=vrstaGoriva;
    }

    public Integer getBrojSjedala(){
        return brojSjedala;
    }
    public String getVrstaGoriva(){
        return vrstaGoriva;
    }
    @Override
    public void detaljanOpisVozila(){
        System.out.println("Auto marke: "+getMarkaVozila()+", model: "+getModelVozila()+", registracija: "+getRegistracijaVozila()+", broj sjedala: "+getBrojSjedala()+", vrsta goriva: "+getVrstaGoriva()+".");

    }
}
