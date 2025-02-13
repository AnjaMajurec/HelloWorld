import database.DatabaseService;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("IZBORNIK: 1 - Unesi novog polaznika");
            System.out.println("2 - Unos novog programa obrazovanja");
            System.out.println("3 - Upiši polaznika na program obrazovanja");
            System.out.println("4 - Prebaci polaznika iz jednog u drugi program obrazovanja");
            System.out.println("5 - Ispis polaznika određenog programa obradovanja (po ID-ju)");
            System.out.println("6 - Kraj");
            System.out.println("Molim Vas izaberite jednu od ponuđenih opcija: ");

            int unos = scanner.nextInt();
            scanner.nextLine();

            switch (unos) {
                case 1:
                    unosNovogPolaznika(scanner);
                    break;

                case 2:
                    unosNovogProgramaObrazovanja(scanner);
                    break;

                case 3:
                    upisPolaznikaNaProgramObrazovanja(scanner);
                    break;

                case 4:
                    prebacivanjePolaznikaNaDrugiProgramObrazovanja(scanner);
                    break;

                case 5:
                    ispisPolaznikaUProgramuObrazovanja(scanner);
                    break;

                case 6:
                    System.out.println("Izašli ste iz aplikacije.");
                    return;

                default:
                    System.out.println("Krivi unos. Probajte ponovno.");
            }
        }
    }

    private static void unosNovogPolaznika(Scanner scanner) {

        System.out.println("Unesite ime polaznika: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite prezime polaznika: ");
        String prezime = scanner.nextLine();

        try (Connection connection = DatabaseService.createConnection()) {
            String callProcedure = "{CALL UnosPolaznika(?,?)}";
            CallableStatement callableStatement = connection.prepareCall(callProcedure);

            callableStatement.setString(1, ime);
            callableStatement.setString(2, prezime);

            callableStatement.execute();
            System.out.println();
            callableStatement.close();

            System.out.println("Polaznik " + ime + " " + prezime + " je uspješno unesen u bazu.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void unosNovogProgramaObrazovanja(Scanner scanner) {
        System.out.println("Unesite naziv novog programa obrazovanja: ");
        String naziv = scanner.nextLine();
        System.out.println("Unesite broj CSVET bodova: ");
        int csvet = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            String query = "INSERT INTO ProgramObrazovanja (Naziv, CSVET) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, naziv);
            statement.setInt(2, csvet);

            int result = statement.executeUpdate();
            System.out.println("Program obrazovanja " + naziv + " je uspješno unesen u bazu.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void upisPolaznikaNaProgramObrazovanja(Scanner scanner) {
        System.out.println("Unesite ID polaznika kojeg želite upisati: ");
        String query1 = "SELECT * FROM Polaznik";

        try (Connection connection = DatabaseService.createConnection();
             PreparedStatement statement = connection.prepareStatement(query1);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idPolaznik = resultSet.getInt("PolaznikID");
                String Ime = resultSet.getString("Ime");
                String Prezime = resultSet.getString("Prezime");
                System.out.println("Ime: " + Ime + ", Prezime: " + Prezime + ", Polaznik ID: " + idPolaznik);
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int polaznikID = scanner.nextInt();

        System.out.println("Unesite ID programa obrazovanja na koji želite upisati navedenog polaznika: ");
        String query2 = "SELECT * FROM ProgramObrazovanja";

        try (Connection connection = DatabaseService.createConnection();
             PreparedStatement statement = connection.prepareStatement(query2);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idProgramObrazovanja = resultSet.getInt("ProgramObrazovanjaID");
                String Naziv = resultSet.getString("Naziv");
                int csvet = resultSet.getInt("CSVET");
                System.out.println("Program obrazovanja: " + Naziv + ", CSVET: " + csvet + ", Program obrazovanja ID: " + idProgramObrazovanja);
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int programObrazovanjaID = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            String query3 = "INSERT INTO Upis (IDPolaznik, IDProgramObrazovanja) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query3);
            statement.setInt(1, polaznikID);
            statement.setInt(2, programObrazovanjaID);

            int result = statement.executeUpdate();
            System.out.println("Polaznik je uspješno upisan!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prebacivanjePolaznikaNaDrugiProgramObrazovanja(Scanner scanner) {
        System.out.println("Unesite ID polaznika kojeg želite prebaciti u novi program obrazovanja: ");
        String query1 = "SELECT * FROM Polaznik";

        try (Connection connection = DatabaseService.createConnection();
             PreparedStatement statement = connection.prepareStatement(query1);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idPolaznik = resultSet.getInt("PolaznikID");
                String Ime = resultSet.getString("Ime");
                String Prezime = resultSet.getString("Prezime");
                System.out.println("Ime: " + Ime + ", Prezime: " + Prezime + ", Polaznik ID: " + idPolaznik);
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int idPolaznik = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Unesite ID programa obrazovanja na koji želite upisati navedenog polaznika: ");
        String query2 = "SELECT * FROM ProgramObrazovanja";

        try (Connection connection = DatabaseService.createConnection();
             PreparedStatement statement = connection.prepareStatement(query2);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idProgramObrazovanja = resultSet.getInt("ProgramObrazovanjaID");
                String Naziv = resultSet.getString("Naziv");
                int csvet = resultSet.getInt("CSVET");
                System.out.println("Program obrazovanja: " + Naziv + ", CSVET: " + csvet + ", Program obrazovanja ID: " + idProgramObrazovanja);
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int idPrograma = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            try {
                String query3 = "DELETE FROM Upis WHERE IDPolaznik=?";
                PreparedStatement statement1 = connection.prepareStatement(query3);
                statement1.setInt(1, idPolaznik);
                int result1 = statement1.executeUpdate();

                if (result1 > 0) {
                    System.out.println("Polaznik obrisan.");
                } else {
                    System.out.println("Nema polaznika s navedenim ID-jem.");
                }
                String query4 = "INSERT INTO Upis VALUES=(?,?)";
                PreparedStatement statement2 = connection.prepareStatement(query4);
                statement2.setInt(1, idPolaznik);
                statement2.setInt(2, idPrograma);

                int result2 = statement2.executeUpdate();

                if (result2 > 0) {
                    System.out.println("Upis obavljem.");
                } else {
                    System.out.println("Nema programa s tim ID-jem.");
                }

                connection.commit();
                System.out.println("Polaznik uspješno prebačen u novi program obrazovanja.");

            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Greška u transakciji: " + e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static void ispisPolaznikaUProgramuObrazovanja(Scanner scanner) {
        System.out.println("Unesite ID programa obrazovanja čije polaznike želite ispisati: ");
        int programObrazovanjaId = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            String query = "SELECT p.Ime AS imePolaznika, p.Prezime AS prezimePolaznika, ProgramObrazovanja.Naziv AS nazivPrograma, " +
                    "ProgramObrazovanja.CSVET AS csvet" +
                    "FROM Polaznik AS p " +
                    "LEFT JOIN ProgramObrazovanja ON p.PolaznikID = ProgramObrazovanja.IDPolaznik " +
                    "WHERE ProgramObrazovanja.ProgramObrazovanjaID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, programObrazovanjaId);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        String imePolaznika = resultSet.getString("imePolaznika");
                        String prezimePolaznika = resultSet.getString("prezimePolaznika");
                        String nazivPrograma = resultSet.getString("nazivPrograma");
                        int csvet = resultSet.getInt("csvet");

                        System.out.println("Polaznik: " + imePolaznika + " " + prezimePolaznika +
                                ", Program obrazovanja: " + nazivPrograma +
                                ", CSVET: " + csvet);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}















