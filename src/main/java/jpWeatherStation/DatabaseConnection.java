package jpWeatherStation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL;
    private final String USER;
    private final String PASSWORD;

    DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
        ConfigLoader conf = new ConfigLoader();
        this.URL = "jdbc:mysql://" + conf.getDbIP() + ":" + conf.getDbPort() + "/" + conf.getDbDatabase();
        this.USER = conf.getDbUser();
        this.PASSWORD = conf.getDbPassword();
    }


    public Connection connect() {
        Connection connection = null;
        try {
            System.out.println("Connecting to MySQL database..."+this.URL);
            connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            System.out.println("Connection to MySQL database established successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            System.out.println("Connection to MySQL database closed successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to close connection to MySQL database.");
            e.printStackTrace();
        }
    }
}
