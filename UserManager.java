import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.io.FileNotFoundException; // Unused import

public class UserManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "password123"; // Hardcoded credentials
    private static final Logger LOGGER = Logger.getLogger(UserManager.class.getName());

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT username FROM users");

            while (resultSet.next()) {
                usernames.add(resultSet.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage()); // Should use logging instead
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace(); // Should use logging instead
            }
        }
        return usernames;
    }

    public String generateUserReport(List<String> usernames) {
        String report = "User Report:\n";
        for (int i = 0; i < usernames.size(); i++) {
            report += "User " + (i + 1) + ": " + usernames.get(i) + "\n"; // Inefficient string concatenation
        }
        return report;
    }
}
