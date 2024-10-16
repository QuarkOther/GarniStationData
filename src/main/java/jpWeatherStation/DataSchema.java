package jpWeatherStation;

import java.time.LocalDateTime;
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
    private String windDirection;
    private String rainRate;
    private String sunRadiation;
    private String uvIndex;

    public void setData(Map<String, String> data){
        this.weatherStationID = data.get("weatherStationID");
        this.password = data.get("password");
        this.action = data.get("action");
        this.realTime = data.get("realTime");
        this.rateFrequency = String.valueOf(Integer.parseInt(data.get("rateFrequency")));
        this.dateTime = String.valueOf(LocalDateTime.parse(data.get("dateTime")));
        this.barometricPressure = String.valueOf(Double.parseDouble(data.get("barometricPressure")));
        this.indoorTempC = String.valueOf((Double.parseDouble(data.get("indoorTemp")) - 32) * 5 / 9);
        this.outdoorTempC = String.valueOf((Double.parseDouble(data.get("outdoorTemp")) - 32) * 5 / 9);
        this.indoorHumidity = String.valueOf(Double.parseDouble(data.get("indoorHumidity")));
        this.outdoorHumidity = String.valueOf(Double.parseDouble(data.get("outdoorHumidity")));
        this.windSpeed = String.valueOf(Double.parseDouble(data.get("windSpeed")));
        this.windDirection = String.valueOf(Integer.parseInt(data.get("windDirection")));
        this.rainRate = String.valueOf(Double.parseDouble(data.get("rainRate")));
        this.sunRadiation = String.valueOf(Double.parseDouble(data.get("sunRadiation")));
        this.uvIndex = String.valueOf(Double.parseDouble(data.get("uvIndex")));
    }

    public Map<String, String> getData(Map<String, String> data){
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
        data.put("rainRate", this.rainRate);
        data.put("sunRadiation", this.sunRadiation);
        data.put("uvIndex", this.uvIndex);
        return data;
    }
}
