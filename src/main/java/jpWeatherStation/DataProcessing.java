package jpWeatherStation;

import java.util.HashMap;
import java.util.Map;

public class DataProcessing {
    private final DataSchema dataSchema;

    public DataProcessing(String rawDataString) {
        this.dataSchema = parseAndSetData(rawDataString);
    }

    public Object getProcessedData() {
        return this.dataSchema.getDataAsMap();
    }

    private DataSchema parseAndSetData(String rawDataString) {
        DataSchema dataSchema = new DataSchema();
        Map<String, String> dataMap = new HashMap<>();

        String[] parts = rawDataString.split("\\?");
        if (parts.length > 1) {
            String[] params = parts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    dataMap.put(keyValue[0], keyValue[1]);
                } else {
                    dataMap.put(keyValue[0], "");
                }
            }
        }

        dataSchema.setData(dataMap);
        return dataSchema;
    }
}
