import jpWeatherStation.DataSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DataSchemaTest {

    @Test
    public void testSetData() {
        Map<String, String> result = getStringStringMap();

        assertEquals("WS123", result.get("weatherStationID"));
        assertEquals("pass123", result.get("password"));
        assertEquals("update", result.get("action"));
        assertEquals("true", result.get("realTime"));
        assertEquals("10", result.get("rateFrequency"));
        assertEquals("2023-10-10T10:10:10", result.get("dateTime"));
        assertEquals("1013.25", result.get("barometricPressure"));
        assertEquals("20.0", result.get("indoorTempC"));
        assertEquals("21.11111111111111", result.get("outdoorTempC"));
        assertEquals("40.0", result.get("indoorHumidity"));
        assertEquals("50.0", result.get("outdoorHumidity"));
        assertEquals("5.0", result.get("windSpeed"));
        assertEquals("180", result.get("windDirection"));
        assertEquals("0.0", result.get("rainRate"));
        assertEquals("200.0", result.get("sunRadiation"));
        assertEquals("3.0", result.get("uvIndex"));
    }

    private static Map<String, String> getStringStringMap() {
        DataSchema dataSchema = new DataSchema();
        Map<String, String> data = new HashMap<>();
        data.put("weatherStationID", "WS123");
        data.put("password", "pass123");
        data.put("action", "update");
        data.put("realTime", "true");
        data.put("rateFrequency", "10");
        data.put("dateTime", "2023-10-10T10:10:10");
        data.put("barometricPressure", "1013.25");
        data.put("indoorTemp", "68.0");
        data.put("outdoorTemp", "70.0");
        data.put("indoorHumidity", "40.0");
        data.put("outdoorHumidity", "50.0");
        data.put("windSpeed", "5.0");
        data.put("windDirection", "180");
        data.put("rainRate", "0.0");
        data.put("sunRadiation", "200.0");
        data.put("uvIndex", "3.0");

        dataSchema.setData(data);
        Map<String, String> result = dataSchema.getDataAsMap();
        return result;
    }
}
