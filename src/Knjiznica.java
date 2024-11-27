import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Knjiznica implements Servis{
    private List<Clan> clanovi;
    private List<Knjiga> knjige;

    public Knjiznica(){
        clanovi=new ArrayList<>();
        knjige=new ArrayList<>();
    }
    public void dodajClana(Clan clan){
        clanovi.add(clan);
    }
    public void dodajKnjigu(Knjiga knjiga){
        knjige.add(knjiga);
    }
    public void vratiKnjigu(Knjiga knjiga){
        knjige.add(knjiga);
    }
    public void posudiKnjigu(Clan clan, Knjiga knjiga){
        if(knjige.contains(knjiga)){
            clan.posudiKnjigu(knjiga);
            knjige.remove(knjiga);
        }
        else {
            System.out.println("Knjiga nije dostupna u knjižnici.");
        }
    }
    public void vratiKnjigu(Clan clan, Knjiga knjiga){
        if(clan.getPosudeneKnjige().contains(knjiga)){
            clan.vratiKnjigu(knjiga);
            dodajKnjigu(knjiga);
        }
        else{
            System.out.println("Član nije posudio navedenu knjigu.");
        }
    }
    public List<Knjiga> getKnjige() {
        return knjige;
    }
    public Clan nadjiClanaPoClanskomBroju(String clanskiBroj) {
        for (Clan clan : clanovi) {
            if (clan.getClanskiBroj().equals(clanskiBroj)) {
                return clan;
            }
        }
        return null;
    }

    public void spremiPodatkeUDatoteku(){
        try{
            FileWriter clanWriter=new FileWriter("clanovi.txt");
            FileWriter knjigeWriter=new FileWriter("knjige.txt");

            for(Clan clan: clanovi){
                clanWriter.write(clan.toString());
                clanWriter.write("\n");
            }
            for(Knjiga knjiga:knjige){
                knjigeWriter.write(knjiga.toString());
                knjigeWriter.write("\n");
            }
            clanWriter.close();
            knjigeWriter.close();
        }
        catch (IOException e){
            System.out.println("Greška pri spremanju podataka u datoteku: "+e.getMessage());
        }
    }

}
