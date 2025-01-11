import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, List<Proizvod>> proizvodiGrupiraniPoKategoriji = new HashMap<>();
        List<Proizvod> voce = new ArrayList<>();
        List<Proizvod> povrce = new ArrayList<>();
        proizvodiGrupiraniPoKategoriji.put("voće", voce);
        proizvodiGrupiraniPoKategoriji.put("povrće", povrce);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Za unos proizvoda u kategorijama (voće, povrće) odaberite 1, za prikaz proizvoda u određenoj kategoriji 2, prikaz svih proizvoda i kategorija 3, za izlaz 4:");
        int unos = scanner.nextInt();
        scanner.nextLine();

        while(unos!=4){
            if(unos==1){
                System.out.println("U koju kategoriju želite unijeti proizvod?");
                String unosKategorije= scanner.nextLine().toLowerCase();
                System.out.println("Koliko proizvoda želite unijeti?");
                Integer brojProizvoda= scanner.nextInt();
                scanner.nextLine();

                for(int i=0;i<brojProizvoda;i++){
                    System.out.println("Unesi ime proizvoda: ");
                    String imeProizvoda = scanner.nextLine();
                    Proizvod proizvod=new Proizvod(imeProizvoda);
                    if(unosKategorije.equals("voće")){
                        proizvodiGrupiraniPoKategoriji.get("voće").add(proizvod);
                    }
                    else if(unosKategorije.equals("povrće")){
                        proizvodiGrupiraniPoKategoriji.get("povrće").add(proizvod);
                    }
                }
            }
            else if (unos==2){
                System.out.println("Unesite kategoriju iz koje želite prikazati proizvode (voće/povrće)");
                String unosKategorije = scanner.nextLine().toLowerCase();
                if(proizvodiGrupiraniPoKategoriji.containsKey(unosKategorije)){
                    List <Proizvod> proizvodi = proizvodiGrupiraniPoKategoriji.get(unosKategorije);
                    for (Proizvod proizvod : proizvodi) {
                        System.out.println(proizvod);
                    }
                }
            }
            else if(unos==3){
                System.out.println("Prikaz svih proizvoda:");
                for (String kategorija : proizvodiGrupiraniPoKategoriji.keySet()) {
                    System.out.println("Kategorija: "+kategorija);
                    List <Proizvod> proizvodi =proizvodiGrupiraniPoKategoriji.get(kategorija);
                    for (Proizvod proizvod : proizvodi) {
                        System.out.println(proizvod);
                    }
                }
            }
            System.out.println("Za unos proizvoda u kategorijama (voće, povrće) odaberite 1, za prikaz proizvoda u određenoj kategoriji 2, prikaz svih proizvoda i kategorija 3, za izlaz 4:");
            unos = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Izašli ste iz aplikacije.");
    }
}







