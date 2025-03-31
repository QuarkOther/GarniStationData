import jpWeatherStation.ConfigLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigLoaderTest {

    @Test
    public void testLoadConfig() {
        ConfigLoader conf = new ConfigLoader();

        assertTrue(conf.getIp().matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b"), "IP address format is invalid");
        assertTrue(conf.getPort().matches("\\d{4}"), "Port number format is invalid");
    }
}