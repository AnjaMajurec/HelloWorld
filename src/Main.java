import database.DatabaseService;

import java.sql.*;
import java.util.List;

public class Main{
    public static void main(String[] args) throws SQLException{
        Connection connection= DatabaseService.createConnection();
        povezivanjeSProceduromZaAzuriranjePrezimena(connection,1,"novoPrezime");
        connection.close();
    }
    public static void povezivanjeSProceduromZaAzuriranjePrezimena(Connection connection, int osobaID, String novoPrezime) throws SQLException{
        String callProcedure="{CALL AzurirajPrezime(?,?)}";
        CallableStatement callableStatement= connection.prepareCall(callProcedure);

        callableStatement.setInt(1,osobaID);
        callableStatement.setString(2,novoPrezime);

        callableStatement.execute();
        System.out.println("Osoba s ID-jem: "+osobaID+" promijenila je prezime na: "+novoPrezime);
        callableStatement.close();
    }
}















