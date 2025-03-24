import jpWeatherStation.DataSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DataSchemaTest {

    @Test
    public void testSetData() {
        DataSchema dataSchema = new DataSchema();
        Map<String, String> data = new HashMap<>();
        data.put("ID", "WS123");
        data.put("PASSWORD", "pass123");
        data.put("action", "update");
        data.put("realtime", "1");
        data.put("rtfreq", "5");
        data.put("dateutc", "now");
        data.put("baromin", "29.92");
        data.put("indoortempf", "68.0");
        data.put("tempf", "70.0");
        data.put("indoorhumidity", "40");
        data.put("humidity", "50");
        data.put("windspeedmph", "10.0");
        data.put("windgustmph", "15.0");
        data.put("winddir", "180");
        data.put("rainin", "0.1");
        data.put("solarradiation", "500.0");
        data.put("UV", "5.0");

        dataSchema.setData(data);

        assertEquals("WS123", dataSchema.getDataAsMap().get("weatherStationID"));
        assertEquals("pass123", dataSchema.getDataAsMap().get("password"));
        assertEquals("update", dataSchema.getDataAsMap().get("action"));
        assertEquals("1", dataSchema.getDataAsMap().get("realTime"));
        assertEquals("5", dataSchema.getDataAsMap().get("rateFrequency"));
        assertNotNull(dataSchema.getDataAsMap().get("dateTime"));
        assertEquals("29.92", dataSchema.getDataAsMap().get("barometricPressure"));
        assertEquals("20.0", dataSchema.getDataAsMap().get("indoorTempC"));
        assertEquals("21.11111111111111", dataSchema.getDataAsMap().get("outdoorTempC"));
        assertEquals("40.0", dataSchema.getDataAsMap().get("indoorHumidity"));
        assertEquals("50.0", dataSchema.getDataAsMap().get("outdoorHumidity"));
        assertEquals("10.0", dataSchema.getDataAsMap().get("windSpeed"));
        assertEquals("15.0", dataSchema.getDataAsMap().get("windGust"));
        assertEquals("180", dataSchema.getDataAsMap().get("windDirection"));
        assertEquals("0.1", dataSchema.getDataAsMap().get("rainRate"));
        assertEquals("500.0", dataSchema.getDataAsMap().get("sunRadiation"));
        assertEquals("5.0", dataSchema.getDataAsMap().get("uvIndex"));
    }
}
