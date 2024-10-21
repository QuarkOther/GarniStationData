package jpWeatherStation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DataSchema dataSchema = new DataSchema();
        System.out.println(dataSchema.getDataAsMap());
    }
}