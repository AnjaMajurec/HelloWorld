public class Student {
    private String ime;
    private String prezime;
    private Double prosjekOcjena;

    public Student(String imeStudenta, String prezimeStudenta, Double prosjekOcjena){
        this.ime=imeStudenta;
        this.prezime=prezimeStudenta;
        this.prosjekOcjena=prosjekOcjena;
    }
   public String getIme(){
        return this.ime;
   }
   public String getPrezime(){
        return this.prezime;
   }
   public Double getProsjekOcjena(){
        return this.prosjekOcjena;
   }
   public String ispisStudenta(){
        return getIme()+" "+getPrezime()+", prosjek ocjena: "+getProsjekOcjena();
   }
}
