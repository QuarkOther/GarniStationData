import jpWeatherStation.ConfigLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigLoaderTest {

    @Test
    public void testLoadConfig() {
        ConfigLoader conf = new ConfigLoader();
        conf.loadConfig();
        assertEquals("10.10.8.33", conf.getIp());
        assertEquals("80", conf.getPort());
    }
}