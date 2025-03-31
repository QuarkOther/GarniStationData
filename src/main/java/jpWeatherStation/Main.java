package jpWeatherStation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConfigLoader conf = new ConfigLoader();
        try {
            new SilentHttpServerDataGetter(conf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}