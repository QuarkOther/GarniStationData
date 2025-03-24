package jpWeatherStation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final String configFile;

    public ConfigLoader(String inputFile){
        this.configFile = inputFile;
    }

    public ConfigLoader(){
        this.configFile = "conf/config.properties";
    }

    private static final Properties properties = new Properties();

    public void loadConfig() {
        try {
            FileInputStream input = new FileInputStream(this.configFile);
            if (input == null) {
                System.out.printf("Sorry, unable to find %s%n", this.configFile);
            }
            else properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getIp() {
        if (properties.getProperty("INPUT_IP") != null) {
            return properties.getProperty("INPUT_IP");
        }
        else return null;
    }


    public static String getPort() {
        if (properties.getProperty("INPUT_PORT") != null) {
            return properties.getProperty("INPUT_PORT");
        }
        else return null;
    }

    public static String getDbIP() {
        if (properties.getProperty("DB_IP") != null) {
            return properties.getProperty("DB_IP");
        }
        else return null;
    }

    public static String getDbPort() {
        if (properties.getProperty("DB_PORT") != null) {
            return properties.getProperty("DB_PORT");
        }
        else return null;
    }

    public static String getDbUser() {
        if (properties.getProperty("DB_USER") != null) {
            return properties.getProperty("DB_USER");
        }
        else return null;
    }

    public static String getDbPassword() {
        if (properties.getProperty("DB_PASSWORD") != null) {
            return properties.getProperty("DB_PASSWORD");
        }
        else return null;
    }

    public static String getDbDatabase() {
        if (properties.getProperty("DB_DATABASE_NAME") != null) {
            return properties.getProperty("DB_DATABASE_NAME");
        }
        else return null;
    }

    public static String getTimeZone() {
        if (properties.getProperty("TIMEZONE") != null) {
            return properties.getProperty("TIMEZONE");
        }
        else {
            return "UTC";
        }
    }
}
