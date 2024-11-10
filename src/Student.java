public class Student {
    private String ime;
    private String prezime;
    private String brojIndeksa;
    private Double prosjekOcjena;

    public Student(String imeStudenta, String prezimeStudenta, String brojIndeksaStudenta, Double prosjekOcjenaStudenta){
        this.ime=imeStudenta;
        this.prezime=prezimeStudenta;
        this.brojIndeksa=brojIndeksaStudenta;
        this.prosjekOcjena=prosjekOcjenaStudenta;
    }
   public String getIme(){
        return this.ime;
   }
   public String getPrezime(){
        return this.prezime;
   }
   public String getBrojIndeksa(){
        return this.brojIndeksa;
   }
   public Double getProsjekOcjena(){
        return this.prosjekOcjena;
   }

}
