import java.util.ArrayList;
import java.util.List;

public class Clan {
    private String ime;
    private String prezime;
    private String clanskiBroj;
    private List<Knjiga> posudeneKnjige;

    public Clan(String ime, String prezime,String clanskiBroj){
        this.ime=ime;
        this.prezime=prezime;
        this.clanskiBroj=clanskiBroj;
        this.posudeneKnjige=new ArrayList<>();
    }
    public String getIme(){
        return ime;
    }
    public String getPrezime(){
        return prezime;
    }
    public String getClanskiBroj(){
        return clanskiBroj;
    }
    public List<Knjiga> getPosudeneKnjige(){
        return posudeneKnjige;
    }
    public void vratiKnjigu(Knjiga knjiga){
        posudeneKnjige.remove(knjiga);
    }
    public void posudiKnjigu(Knjiga knjiga){
        posudeneKnjige.add(knjiga);
    }
    public String toString(){
        String ispis="Ime: "+ime+", prezime: "+prezime+", članski broj: "+clanskiBroj+", posuđene knjige: ";
        for(Knjiga knjiga: posudeneKnjige){
            ispis=ispis+knjiga.toString()+",2";
        }
        return ispis;
    }
}
