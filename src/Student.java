public class Student {
    private String ime;
    private String prezime;
    private String brojIndeksa;

    public Student(String imeStudenta, String prezimeStudenta, String brojIndeksaStudenta){
        this.ime=imeStudenta;
        this.prezime=prezimeStudenta;
        this.brojIndeksa=brojIndeksaStudenta;
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
   public String ispisStudenta(){
        return getIme()+" "+getPrezime()+", broj indeksa: "+getBrojIndeksa();
   }
}
