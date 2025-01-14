import java.lang.String;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // Here you would call your method with the arguments from inputLine
            String result = executeTask(inputLine);
            out.println(result);
        }

        socket.close();
    }

    private static String executeTask(String args) {
        // Implement your task execution logic here, using args
        return "Result of: " + args;
    }
}