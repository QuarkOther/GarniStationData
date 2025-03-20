package jpWeatherStation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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


    public static int getPort() {
        return Integer.parseInt(properties.getProperty("INPUT_PORT"));
    }
}
