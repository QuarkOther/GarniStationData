package jpWeatherStation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DataSchema {
    private String weatherStationID;
    private String password;
    private String action;
    private String realTime;
    private String rateFrequency;
    private String dateTime;
    private String barometricPressure;
    private String indoorTempC;
    private String outdoorTempC;
    private String indoorHumidity;
    private String outdoorHumidity;
    private String windSpeed;
    private String windGust;
    private String windDirection;
    private String rainRate;
    private String sunRadiation;
    private String uvIndex;

    public void setData(Map<String, String> data){
        this.weatherStationID = data.get("ID");
        this.password = data.get("PASSWORD");
        this.action = data.get("action");
        this.realTime = data.get("realtime");
        this.rateFrequency = String.valueOf(Integer.parseInt(data.get("rtfreq")));
        if ("now".equals(data.get("dateutc"))) {
            this.dateTime = LocalDateTime.now(ZoneId.of(ConfigLoader.getTimeZone())).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            this.dateTime = String.valueOf(LocalDateTime.parse(data.get("dateutc")));
        }
        this.barometricPressure = String.valueOf(Double.parseDouble(data.get("baromin")));
        this.indoorTempC = String.valueOf((Double.parseDouble(data.get("indoortempf")) - 32) * 5 / 9);
        this.outdoorTempC = String.valueOf((Double.parseDouble(data.get("tempf")) - 32) * 5 / 9);
        this.indoorHumidity = String.valueOf(Double.parseDouble(data.get("indoorhumidity")));
        this.outdoorHumidity = String.valueOf(Double.parseDouble(data.get("humidity")));
        this.windSpeed = String.valueOf(Double.parseDouble(data.get("windspeedmph")));
        this.windGust = String.valueOf(Double.parseDouble(data.get("windgustmph")));
        this.windDirection = String.valueOf(Integer.parseInt(data.get("winddir")));
        this.rainRate = String.valueOf(Double.parseDouble(data.get("rainin")));
        this.sunRadiation = String.valueOf(Double.parseDouble(data.get("solarradiation")));
        this.uvIndex = String.valueOf(Double.parseDouble(data.get("UV")));
    }

    public Map<String, String> getDataAsMap(){
        Map<String, String> data = new HashMap<>();
        data.put("weatherStationID", this.weatherStationID);
        data.put("password", this.password);
        data.put("action", this.action);
        data.put("realTime", this.realTime);
        data.put("rateFrequency", this.rateFrequency);
        data.put("dateTime", this.dateTime);
        data.put("barometricPressure", this.barometricPressure);
        data.put("indoorTempC", this.indoorTempC);
        data.put("outdoorTempC", this.outdoorTempC);
        data.put("indoorHumidity", this.indoorHumidity);
        data.put("outdoorHumidity", this.outdoorHumidity);
        data.put("windSpeed", this.windSpeed);
        data.put("windDirection", this.windDirection);
        data.put("windGust", this.windGust);
        data.put("rainRate", this.rainRate);
        data.put("sunRadiation", this.sunRadiation);
        data.put("uvIndex", this.uvIndex);
        return data;
    }
}
