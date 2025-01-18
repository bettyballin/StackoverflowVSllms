import java.lang.String;
// Server side - Send Graph over HTTP:
import java.net.*;
import java.io.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpExample {

    public static void main(String[] args) throws IOException, JsonProcessingException {
        ServerSocket servsock = new ServerSocket(9090);
        ObjectMapper objectMapper = new ObjectMapper();

        // Assuming yourBigGraphObject is initialized here
        Graph yourBigGraphObject = new Graph(); // Replace with actual graph object        

        while (true) {
            Socket sock = servsock.accept();
            BufferedReader insock = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String line;
            PrintWriter osock = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
            while ((line = insock.readLine()) != null) {
                if (line.equalsIgnoreCase("GET /graph")) { // assuming some protocol like HTTP for simplicity
                    String jsonGraph = objectMapper.writeValueAsString(yourBigGraphObject); // your graph serialization happens here
                    osock.println(jsonGraph);
                    break;
                } else if (line.trim().equalsIgnoreCase("")) { // handling HTTP headers end and waiting for request line in a real application but skipping it for brevity
                    continue;
                } else {
                    System.out.println(line);
                }
            }
            sock.close();
        }
    }
}

// Sample Graph class
class Graph {
    // Define members of Graph class
}