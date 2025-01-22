import database.DatabaseService;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ID računa koji želite izbrisati iz baze: ");
        int unosID = scanner.nextInt();
        try (Connection conn = DatabaseService.createConnection()) {
            conn.setAutoCommit(false);
            try {
                String query1 = "DELETE FROM Stavka WHERE RacunID = ?";
                try (PreparedStatement stmt1 = conn.prepareStatement(query1)) {
                    stmt1.setInt(1, unosID);
                    stmt1.executeUpdate();
                }

                String query2 = "DELETE FROM Racun WHERE IDRacun = ?";
                try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
                    stmt2.setInt(1, unosID);
                    stmt2.executeUpdate();
                }
                conn.commit();
                System.out.println("Račun i stavke uspješno izbrisani.");

            } catch (SQLException e) {
                conn.rollback();
            }
        }
    }
}











