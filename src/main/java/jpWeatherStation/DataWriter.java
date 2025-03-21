package jpWeatherStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DataWriter {

    public DataWriter(Map<String, String> data, Connection dbConnection) {
        try {
            createTableIfNotExists(dbConnection);

            String query = "INSERT INTO weather_data_vt (weatherStationID, password, action, realTime, rateFrequency, dateTime, barometricPressure, indoorTempC, outdoorTempC, indoorHumidity, outdoorHumidity, windSpeed, windDirection, windGust, rainRate, sunRadiation, uvIndex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, data.get("weatherStationID"));
            preparedStatement.setString(2, data.get("password"));
            preparedStatement.setString(3, data.get("action"));
            preparedStatement.setString(4, data.get("realTime"));
            preparedStatement.setString(5, data.get("rateFrequency"));
            preparedStatement.setString(6, data.get("dateTime"));
            preparedStatement.setString(7, data.get("barometricPressure"));
            preparedStatement.setString(8, data.get("indoorTempC"));
            preparedStatement.setString(9, data.get("outdoorTempC"));
            preparedStatement.setString(10, data.get("indoorHumidity"));
            preparedStatement.setString(11, data.get("outdoorHumidity"));
            preparedStatement.setString(12, data.get("windSpeed"));
            preparedStatement.setString(13, data.get("windDirection"));
            preparedStatement.setString(14, data.get("windGust"));
            preparedStatement.setString(15, data.get("rainRate"));
            preparedStatement.setString(16, data.get("sunRadiation"));
            preparedStatement.setString(17, data.get("uvIndex"));
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean createTableIfNotExists(Connection connection){
        try {
            String query = "CREATE TABLE IF NOT EXISTS weather_data_vt (weatherStationID VARCHAR(255), password VARCHAR(255), action VARCHAR(255), realTime VARCHAR(255), rateFrequency VARCHAR(255), dateTime VARCHAR(255), barometricPressure VARCHAR(255), indoorTempC VARCHAR(255), outdoorTempC VARCHAR(255), indoorHumidity VARCHAR(255), outdoorHumidity VARCHAR(255), windSpeed VARCHAR(255), windDirection VARCHAR(255), windGust VARCHAR(255), rainRate VARCHAR(255), sunRadiation VARCHAR(255), uvIndex VARCHAR(255))";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Table created successfully.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
