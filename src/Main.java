import database.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws SQLException{
        Connection connection= DatabaseService.createConnection();
        unos5Osoba(connection);
        connection.close();
    }
    public static void unos5Osoba(Connection connection) throws SQLException{
        List<Osoba> osobe=new ArrayList<>();
        osobe.add(new Osoba("Anja","Majurec","1998-07-27"));
        osobe.add(new Osoba("Ivor","Stojevski","1998-03-13"));
        osobe.add(new Osoba("Iva","Foret","1998-04-26"));
        osobe.add(new Osoba("Lara","Mandić","1998-08-19"));
        osobe.add(new Osoba("Karlo","Boos","1995-05-09"));

        String query="INSERT INTO Osoba(Ime, Prezime, DatumRodenja) VALUES (?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(query);

        for (Osoba osoba : osobe) {
            preparedStatement.setString(1,osoba.getIme());
            preparedStatement.setString(2,osoba.getPrezime());
            preparedStatement.setString(3,osoba.getDatumRodenja());

            preparedStatement.executeUpdate();
            System.out.println("Osoba "+osoba.getIme()+" "+osoba.getPrezime()+" dodana je u tablicu.");

        }
        preparedStatement.close();

    }
}















