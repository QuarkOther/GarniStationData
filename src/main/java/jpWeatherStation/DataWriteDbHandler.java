package jpWeatherStation;

import java.sql.Connection;
import java.util.Map;

public class DataWriteDbHandler {
    public DataWriteDbHandler(Map<String, String> writeToDbData) {
        Connection mysqlConnection = new DatabaseConnection().connect();
        new DataWriter(writeToDbData, mysqlConnection);
        DatabaseConnection.closeConnection(mysqlConnection);
    }
}
