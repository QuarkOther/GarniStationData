package jpWeatherStation;

import java.io.IOException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            new SilentHttpServerDataGetter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}