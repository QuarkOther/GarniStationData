package jpWeatherStation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("MySQL JDBC Driver Registered!");

//        try {
//            new SilentHttpServerDataGetter();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}