import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    private List<Vozilo> vozila;
    public EvidencijaVozila() {
        vozila = new ArrayList<>(); // Inicijalizacija liste
    }

    public void dodajVozilo(Vozilo vozilo){
        vozila.add(vozilo);
    }
    public void spremiPodatkeUDatoteku(String datoteka){
        try{
            FileWriter voziloWriter=new FileWriter(datoteka);

            for(Vozilo vozilo:vozila){
                voziloWriter.write(vozilo.prikaziPodatke());
                voziloWriter.write("\n");
            }
            voziloWriter.close();
        }
        catch(IOException e){
            System.out.print("Greška pri spremanju podataka u datoteku: "+e.getMessage());
        }
    }
    public void ucitajPodatkeIzDatoteke(String datoteka){
        try{
           List<String> redci= Files.readAllLines(Paths.get(datoteka));
           for(String redak:redci){
               System.out.println(redak);
           }
        }
        catch(IOException e){
            System.out.println("Greška prilikom čitanja datoteke: "+e.getMessage());
        }
    }
}
