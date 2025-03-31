package jpWeatherStation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConfigLoader config = new ConfigLoader();
        try {
            new SilentHttpServerDataGetter(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}