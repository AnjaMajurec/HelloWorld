public class Kamion extends Vozilo{
    private Double nosivost;
    private String prikolica;

    public Kamion(String markaVozila, String modelVozila, String registracijaVozila, Double nosivost, String prikolica){
        super(markaVozila,modelVozila,registracijaVozila);
        this.nosivost=nosivost;
        this.prikolica=prikolica;
    }
    public Double getNosivost(){
        return nosivost;
    }
    public String getPrikolica(){
        return prikolica;
    }
    @Override
    public void detaljanOpisVozila(){
        System.out.println("Kamion marke: "+getMarkaVozila()+", model: "+getModelVozila()+", registracija: "+getRegistracijaVozila()+", nosivost: "+getNosivost()+", prikolica: "+getPrikolica()+".");

    }
}
