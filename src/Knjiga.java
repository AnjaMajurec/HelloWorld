public class Knjiga {
    private String naziv;
    private String autor;
    private String godinaIzdanja;

    public Knjiga(String naziv, String autor, String godinaIzdanja){
        this.naziv=naziv;
        this.autor=autor;
        this.godinaIzdanja=godinaIzdanja;
    }
    public String getNaziv(){
        return naziv;
    }
    public String getAutor(){
        return autor;
    }
    public String getGodinaIzdanja(){
        return godinaIzdanja;
    }
    public String toString(){
        return naziv+", autor: "+autor+", ID: "+godinaIzdanja+", ";
    }
}
