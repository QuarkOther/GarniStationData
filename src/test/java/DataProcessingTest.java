import jpWeatherStation.DataProcessing;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessingTest {
    @Test
    public void testParseAndSetData() {
        DataProcessing dataProcessing = new DataProcessing("/weatherstation/updateweatherstation.php?ID=01&PASSWORD=123&action=updateraww&realtime=1&rtfreq=5&dateutc=now&baromin=29.81&tempf=48&dewptf=47.6&humidity=97&windspeedmph=1.5&windgustmph=1.5&winddir=324&rainin=0.0&dailyrainin=0.0&solarradiation=157.21&UV=1.6&indoortempf=73.5&indoorhumidity=50");
        Map<String, String> data = new HashMap<>();
        data.put("weatherStationID", "01");
        data.put("password", "123");
        data.put("action", "updateraww");
        data.put("realTime", "1");
        data.put("rateFrequency", "5");
        data.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        data.put("barometricPressure", "29.81");
        data.put("indoorTempC", "23.055555555555557");
        data.put("outdoorTempC", "8.88888888888889");
        data.put("indoorHumidity", "50.0");
        data.put("outdoorHumidity", "97.0");
        data.put("windSpeed", "1.5");
        data.put("windDirection", "324");
        data.put("windGust", "1.5");
        data.put("rainRate", "0.0");
        data.put("sunRadiation", "157.21");
        data.put("uvIndex", "1.6");
        assertEquals(data, dataProcessing.getProcessedData());
    }
}
