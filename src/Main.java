import database.DatabaseService;
import java.sql.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("IZBORNIK: 1 - Unos novog grada ");
            System.out.println("2 - Izmjena postojećeg grada");
            System.out.println("3 - Brisanje grada");
            System.out.println("4 - Prikaz svih gradova sortiranih po nazivu");
            System.out.println("5 - Kraj");
            System.out.println("Molim Vas izaberite jednu od ponuđenih opcija: ");

            int unos = scanner.nextInt();
            scanner.nextLine();

            switch(unos){
                case 1:
                    unosNovogGrada(scanner);
                    break;

                case 2:
                    izmjenaGrada(scanner);
                    break;

                case 3:
                    brisanjeGrada(scanner);
                    break;

                case 4:
                    prikazSvihGradova();
                    break;

                case 5:
                    System.out.println("Izašli ste iz aplikacije.");
                    return;

                default:
                    System.out.println("Krivi unos. Probajte ponovno.");
            }
        }
    }
    private static void unosNovogGrada(Scanner scanner){
        System.out.println("Unesite naziv grada: ");
        String nazivGrada= scanner.nextLine();

        System.out.println("Popis država koje su u bazi:");
        prikazSvihDrzava();

        System.out.println("Unesite ID države za Vaš novi grad: ");
        int idDrzave=scanner.nextInt();
        scanner.nextLine();

        try(Connection connection=DatabaseService.createConnection()) {
            String query="INSERT INTO Grad (Naziv, DrzavaID) VALUES (?,?)";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,nazivGrada);
            statement.setInt(2,idDrzave);

            int result= statement.executeUpdate();
            System.out.println("Grad "+nazivGrada+" je uspješno unesen u bazu.");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    private static void izmjenaGrada(Scanner scanner){
        System.out.println("Unesite ID grada koji želite izmjeniti: ");
        int idGrada= scanner.nextInt();

        System.out.println("Popis država koje su u bazi:");
        prikazSvihDrzava();

        System.out.println("Unesite novi ID države za grad: ");
        int idDrzave= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Unesite novi naziv grada za odabranu državu: ");
        String nazivGrada= scanner.nextLine();

        try(Connection connection=DatabaseService.createConnection()){
            String query="UPDATE Grad SET Naziv = ?, DrzavaID = ? WHERE IDGrad = ?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,nazivGrada);
            statement.setInt(2,idDrzave);
            statement.setInt(3,idGrada);

            int result= statement.executeUpdate();
            System.out.println("Grad je uspješno promijenjen u bazi.");
        } catch(SQLException e){
            e.printStackTrace();
        }

    }
    private static void brisanjeGrada(Scanner scanner){
        System.out.println("Unesite ID grada koji želite obrisati: ");
        int idGrada= scanner.nextInt();
        scanner.nextLine();

        try (Connection connection=DatabaseService.createConnection()) {
            String query = "DELETE FROM Grad WHERE IDGrad = ?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1, idGrada);

            int result= statement.executeUpdate();
            System.out.println("Grad je uspješno obrisan u bazi.");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static void prikazSvihDrzava(){
        try(Connection connection=DatabaseService.createConnection()){
            String query ="SELECT * FROM Drzava ORDER BY Naziv";
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()) {
                System.out.println("ID Država: " + resultSet.getInt("IDDrzava") + ", Naziv države: " + resultSet.getString("Naziv"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static void prikazSvihGradova(){
        try(Connection connection=DatabaseService.createConnection()){
            String query = "SELECT * FROM Grad ORDER BY Naziv";
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println("ID Grada: "+resultSet.getInt("IDGrad")+", Naziv: "+resultSet.getString("Naziv")+", ID Država: "+resultSet.getInt("DrzavaID"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}















