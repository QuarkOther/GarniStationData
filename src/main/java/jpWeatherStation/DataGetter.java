package jpWeatherStation;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataGetter {
    private String inputIp;
    private int inputPort;

    public DataGetter() {;
        this.inputIp = ConfigLoader.getIp();
        this.inputPort = ConfigLoader.getPort();
    }

    public String getData() {
        String result = "";
        try {
            URL url = new URL("http://" + inputIp + ":" + inputPort);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = conn.getInputStream();
            result = new String(in.readAllBytes());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}