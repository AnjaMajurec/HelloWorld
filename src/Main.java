import database.DatabaseService;

import java.awt.im.spi.InputMethod;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws SQLException{
        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("IZBORNIK: 1 - Dodavanje autora");
            System.out.println("2 - Dodavanje knjiga");
            System.out.println("3 - Dohvaćanje knjiga autora");
            System.out.println("4 - Ažuriranje naslova knjige");
            System.out.println("5 - Dohvacanje autora bez knjige");
            System.out.println("6 - Kraj");
            System.out.println("Molim Vas izaberite jednu od ponuđenih opcija: ");

            int unos = scanner.nextInt();
            scanner.nextLine();

            switch(unos){
                case 1:
                    dodavanjeAutora(scanner);
                    break;

                case 2:
                    dodavanjeKnjige(scanner);
                    break;

                case 3:
                    dohvacanjeKnjigaAutora(scanner);
                    break;

                case 4:
                    azuriranjeNaslovaKnjige(scanner);
                    break;

                case 5:
                    dohvacanjeAutoraBezKnjige();
                    break;

                case 6:
                    System.out.println("Izašli ste iz aplikacije.");
                    return;

                default:
                    System.out.println("Krivi unos. Probajte ponovno.");
            }
        }
    }

    private static void dodavanjeAutora(Scanner scanner){

        System.out.println("Unesite ime autora: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite prezime autora: ");
        String prezime = scanner.nextLine();
        System.out.println("Unesite nacionalnost autora: ");
        String nacionalnost = scanner.nextLine();

        try(Connection connection=DatabaseService.createConnection()) {
            String query="INSERT INTO Autor (Ime, Prezime, Nacionalnost) VALUES (?,?,?)";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, ime);
            statement.setString(2,prezime);
            statement.setString(3,nacionalnost);


            int result= statement.executeUpdate();
            System.out.println("Autor "+ime+" "+prezime+" je uspješno unesen u bazu.");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    private static void dodavanjeKnjige(Scanner scanner){

        System.out.println("Unesite iD autora: ");
        String autorID = scanner.nextLine();
        System.out.println("Unesite naslov knjige: ");
        String naslovKnjige = scanner.nextLine();
        System.out.println("Unesite godinu izdanja knjige: ");
        String godinaIzdanjaKnjige = scanner.nextLine();

        try(Connection connection=DatabaseService.createConnection()) {
            String query="INSERT INTO Knjiga (Naslov, GodinaIzdanja, AutorId) VALUES (?,?,?)";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, naslovKnjige);
            statement.setString(2,godinaIzdanjaKnjige);
            statement.setString(3,autorID);


            int result= statement.executeUpdate();
            System.out.println("Knjiga "+naslovKnjige+" je uspješno unesena u bazu.");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    private static void dohvacanjeKnjigaAutora(Scanner scanner){
        System.out.println("Unesite prezime autora čiji popis knjiga želite vidjeti: ");
        String unosPrezime=scanner.nextLine();
        try(Connection connection=DatabaseService.createConnection()){
            String query = "SELECT a.Prezime, k.Naslov, k.GodinaIzdanja FROM Autor AS a LEFT JOIN Knjiga AS k ON a.Id=k.AutorId WHERE a.Prezime=?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, unosPrezime);

            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                System.out.println("Naslov: "+resultSet.getString("Naslov")+", Godina izdanja: "+resultSet.getString("GodinaIzdanja")+", Prezime autora: "+unosPrezime);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static void azuriranjeNaslovaKnjige(Scanner scanner){
        System.out.println("Unesite ID knjige čiji naslov želite izmjeniti: ");
        int idKnjige= scanner.nextInt();
        scanner.nextLine();


        System.out.println("Unesite novi naslov za odabranu knjigu: ");
        String noviNaslov= scanner.nextLine();


        try(Connection connection=DatabaseService.createConnection()){
            String query="UPDATE Knjiga SET Naslov = ? WHERE Id = ?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,noviNaslov);
            statement.setInt(2,idKnjige);

            int result= statement.executeUpdate();
            System.out.println("Naslov je uspješno promijenjen u bazi.");
        } catch(SQLException e){
            e.printStackTrace();
        }

    }
    private static void dohvacanjeAutoraBezKnjige() {
        String query = "SELECT a.Id, a.Ime, a.Prezime, k.AutorId FROM Autor AS a LEFT JOIN Knjiga AS k ON a.Id=k.AutorId WHERE k.Id IS NULL ";

        try (Connection connection = DatabaseService.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            boolean provjera = false;
            while (resultSet.next()) {
                provjera = true;
                int idAutor = resultSet.getInt("Id");
                String ime = resultSet.getString("Ime");
                String prezime = resultSet.getString("Prezime");

                // Ispis autora
                System.out.println("ID autora: " + idAutor + ", Ime: " + ime + ", Prezime: " + prezime);
            }

            if (!provjera) {
                System.out.println("Nema autora bez knjiga.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}















