package jpWeatherStation;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class SilentHttpServerDataGetter {

    public SilentHttpServerDataGetter() throws IOException {
        ConfigLoader conf = new ConfigLoader();
        int port = Integer.parseInt(conf.getPort());
        String ip = conf.getIp();

        HttpServer server = HttpServer.create(new InetSocketAddress(ip,port), 0);
        server.createContext("/", new SilentHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("HTTP Server started on: " + ip + ":" + port);
    }

    static class SilentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("Received request: " + exchange.getRequestMethod() + " " + exchange.getRequestURI());

            Headers headers = exchange.getRequestHeaders();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            String receivedMsg = exchange.getRequestURI().toString();
            DataProcessing dataProcess = new DataProcessing(receivedMsg);
            Map<String, String> writeToDbData = dataProcess.getProcessedData();
            System.out.println("Data to write to DB\n" + writeToDbData);

            new DataWriteDbHandler(writeToDbData);

            exchange.close();
        }
    }
}
