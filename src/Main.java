import database.DatabaseService;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("IZBORNIK: 1 - Unesi novog učenika");
            System.out.println("2 - Unos novog razreda");
            System.out.println("3 - Prebacivanje učenika u drugi razred");
            System.out.println("4 - Ispis učenika iz pojedinog razreda");
            System.out.println("5 - Brisanje učenika");
            System.out.println("6 - Update imena i prezimena nastavnika");
            System.out.println("7 - Kraj");
            System.out.println("Molim Vas izaberite jednu od ponuđenih opcija: ");

            int unos = scanner.nextInt();
            scanner.nextLine();

            switch (unos) {
                case 1:
                    unosNovogUcenika(scanner);
                    break;

                case 2:
                    unosNovogRazreda(scanner);
                    break;

                case 3:
                    prebacivanjeUcenikaUNoviRazred(scanner);
                    break;

                case 4:
                    ispisSvihUcenikaURazredu(scanner);
                    break;

                case 5:
                    brisanjeUcenika(scanner);
                    break;

                case 6:
                    updateImenaPrezimenaNastavnika(scanner);

                case 7:
                    System.out.println("Izašli ste iz aplikacije.");
                    return;

                default:
                    System.out.println("Krivi unos. Probajte ponovno.");
            }
        }
    }

    private static void unosNovogUcenika(Scanner scanner) {

        System.out.println("Unesite ime ucenika: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite prezime ucenika: ");
        String prezime = scanner.nextLine();
        System.out.println("Unesite ID razreda u koji upisujete učenika (ili unesite 0 za povratak u glavni izbornik s odabirom unosa novog razreda): ");
        String query = "SELECT * FROM Razred";

        try (Connection connection = DatabaseService.createConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()) {
                int idRazred = resultSet.getInt("Id");
                String Naziv = resultSet.getString("Naziv");
                int NastavnikId = resultSet.getInt("NastavnikId");

                System.out.println("ID razreda: " + idRazred + ", Naziv: " + Naziv + ", Nastavnik ID: " + NastavnikId);
            };

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String unos = scanner.nextLine();

        if (unos.equals("0")) {
            return;
        }

        try (Connection connection = DatabaseService.createConnection()) {
            String query2 = "INSERT INTO Ucenik (Ime, Prezime, RazredId ) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query2);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, unos);


            int result = statement.executeUpdate();
            System.out.println("Ucenik " + ime + " " + prezime + " je uspješno unesen u bazu.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static void brisanjeUcenika(Scanner scanner) {
        System.out.println("Unesite ID učenika kojeg želite obrisati: ");
        int IDucenika = scanner.nextInt();
        try (Connection connection = DatabaseService.createConnection()) {
            String query = "DELETE FROM Ucenik WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, IDucenika);
            int result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void updateImenaPrezimenaNastavnika(Scanner scanner) {
        System.out.println("Unesite ID nastavnika čije ime i prezime želite izmjeniti: ");
        int idNastavnika = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Unesite novo ime nastavnika: ");
        String novoIme = scanner.nextLine();
        System.out.println("Unesite novo prezime nastavnika: ");
        String novoPrezime = scanner.nextLine();
        System.out.println("Unesite novi email nastavnika: ");
        String noviEmail = scanner.nextLine();
        try (Connection connection = DatabaseService.createConnection()) {
            String query = "UPDATE Nastavnik SET Ime = ?, Prezime = ?, Email = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, novoIme);
            statement.setString(2, novoPrezime);
            statement.setString(3, noviEmail);
            statement.setInt(4, idNastavnika);

            int result = statement.executeUpdate();
            System.out.println("Nastavnik uspješno promijenjen u bazi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prebacivanjeUcenikaUNoviRazred(Scanner scanner) {
        System.out.println("Unesite ID učenika kojeg želite prebaciti: ");
        int ucenikId = scanner.nextInt();
        System.out.println("Unesite ID novog razreda u koji želite prebaciti učenika: ");
        int noviRazredId = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            String query = "UPDATE Ucenik SET RazredId = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, noviRazredId);
            statement.setInt(2, ucenikId);

            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Učenik je uspješno prebačen u novi razred.");
            } else {
                System.out.println("Nema učenika s tim ID-jem.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void unosNovogRazreda(Scanner scanner) {
        System.out.println("Unesite ime nastavnika: ");
        String imeNastavnika = scanner.nextLine();
        System.out.println("Unesite prezime nastavnika: ");
        String prezimeNastavnika = scanner.nextLine();
        System.out.println("Unesite email nastavnika: ");
        String emailNastavnika = scanner.nextLine();

        int nastavnikId = 0;
        try (Connection connection = DatabaseService.createConnection()) {
            String query = "INSERT INTO Nastavnik (Ime, Prezime, Email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, imeNastavnika);
            statement.setString(2, prezimeNastavnika);
            statement.setString(3, emailNastavnika);
            int result = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                nastavnikId = rs.getInt(1);
                System.out.println("Nastavnik ID: " + nastavnikId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (nastavnikId > 0) {
            System.out.println("Unesite naziv novog razreda: ");
            String nazivRazreda = scanner.nextLine();

            try (Connection connection = DatabaseService.createConnection()) {
                String query = "INSERT INTO Razred (Naziv, NastavnikId) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, nazivRazreda);
                statement.setInt(2, nastavnikId);

                int result = statement.executeUpdate();
                System.out.println("Razred " + nazivRazreda + " je uspješno unesen u bazu.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    private static void ispisSvihUcenikaURazredu(Scanner scanner) {
        System.out.println("Unesite ID razreda čije učenike želite ispisati: ");
        int IDrazreda = scanner.nextInt();

        try (Connection connection = DatabaseService.createConnection()) {
            String query = "SELECT u.Ime AS imeUcenika, u.Prezime AS prezimeUcenika, Razred.Naziv AS nazivRazreda, " +
                    "Nastavnik.Ime AS imeNastavnika, Nastavnik.Prezime AS prezimeNastavnika " +
                    "FROM Ucenik AS u " +
                    "LEFT JOIN Razred ON u.RazredId = Razred.Id " +
                    "LEFT JOIN Nastavnik ON Nastavnik.Id = Razred.NastavnikId " +
                    "WHERE Razred.Id = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, IDrazreda);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        String imeUcenika = resultSet.getString("imeUcenika");
                        String prezimeUcenika = resultSet.getString("prezimeUcenika");
                        String nazivRazreda = resultSet.getString("nazivRazreda");
                        String imeNastavnika = resultSet.getString("imeNastavnika");
                        String prezimeNastavnika = resultSet.getString("prezimeNastavnika");

                        System.out.println("Učenik: " + imeUcenika + " " + prezimeUcenika +
                                ", Razred: " + nazivRazreda +
                                ", Nastavnik: " + imeNastavnika + " " + prezimeNastavnika);

                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}















