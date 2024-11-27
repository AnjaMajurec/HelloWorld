public class Knjiga {
    private String naziv;
    private String autor;
    private String IDknjiga;

    public Knjiga(String naziv, String autor, String IDknjiga){
        this.naziv=naziv;
        this.autor=autor;
        this.IDknjiga=IDknjiga;
    }
    public String getNaziv(){
        return naziv;
    }
    public String getAutor(){
        return autor;
    }
    public String getIDknjiga(){
        return IDknjiga;
    }
    public String toString(){
        return naziv+", autor: "+autor+", ID: "+IDknjiga+", ";
    }
}
