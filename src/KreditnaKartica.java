public class KreditnaKartica implements Placanje {
    private double iznos;
    @Override
    public void platiti(double iznos){
        this.iznos=iznos;
        System.out.println("Izvršeno je plaćanje.");
    }
    @Override
    public String getDetalje(){
        return "Plaćanje je izvšeno putem kreditne kartice, a iznos terećenja je: "+iznos+" eura.";
    }
    @Override
    public double vratiIznos(){
        return iznos;
    }
}
