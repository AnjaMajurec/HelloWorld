import database.DatabaseService;

import java.sql.*;
import java.util.List;

public class Main{
    public static void main(String[] args) throws SQLException{
        Connection connection= DatabaseService.createConnection();
        ObrisiOsobePoDatumuRodenja(connection,"1998-07-27");
        connection.close();
    }
    public static void ObrisiOsobePoDatumuRodenja(Connection connection, String minDatumRodenja) throws SQLException{
        String callProcedure="{CALL ObrisiPoDatumuRodenja(?)}";
        CallableStatement callableStatement= connection.prepareCall(callProcedure);

        callableStatement.setString(1,minDatumRodenja);

        callableStatement.execute();
        System.out.println("Uspješno su obrisane sve osobe s datum rođenja prije: "+minDatumRodenja);
        callableStatement.close();
    }
}















