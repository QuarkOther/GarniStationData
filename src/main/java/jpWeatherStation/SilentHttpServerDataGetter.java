package jpWeatherStation;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class SilentHttpServerDataGetter {

    public SilentHttpServerDataGetter() throws IOException {
        ConfigLoader conf = new ConfigLoader();
        conf.loadConfig();
        int port = Integer.parseInt(conf.getPort());
        String ip = conf.getIp();

        HttpServer server = HttpServer.create(new InetSocketAddress(ip,port), 0);
        server.createContext("/", new SilentHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("HTTP Server started on port " + port);
    }

    static class SilentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("Received request: " + exchange.getRequestMethod() + " " + exchange.getRequestURI());

            // Print request headers
            Headers headers = exchange.getRequestHeaders();
            System.out.println("Headers:");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            InputStream inputStream = exchange.getRequestBody();
            String requestBody = new String(inputStream.readAllBytes());
            System.out.println("Request Body:\n" + exchange.getRequestURI());

            exchange.close(); // Simply close the connection without responding
        }
    }
}
