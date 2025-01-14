import java.io.*;
import java.net.*;

public class SlaveServer {

    public static void main(String[] args) throws IOException {
        ServerSocket slaveServer = new ServerSocket(9001);
        while (true) {
            Socket clientSocket = slaveServer.accept();
            // Handle each request in a separate thread
            new Thread(new RequestHandler(clientSocket)).start();
        }
    }

    private static class RequestHandler implements Runnable {
        private final Socket connection;

        public RequestHandler(Socket socket) {
            this.connection = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
                PrintWriter out = new PrintWriter(
                    connection.getOutputStream(), true);
                Process layoutProcess = startLayoutProcess()
            ) {
                // Read from the client and write to the process's input stream
                String request;
                while ((request = reader.readLine()) != null) {
                    layoutProcess.getOutputStream().write(request.getBytes());
                    layoutProcess.getOutputStream().flush();

                    // Read from the process's output and send it back to the master/client
                    BufferedReader processOutputReader = new BufferedReader(
                        new InputStreamReader(layoutProcess.getInputStream())
                    );
                    String responseLine;
                    while ((responseLine = processOutputReader.readLine()) != null) {
                        out.println(responseLine);
                    }
                    processOutputReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static Process startLayoutProcess() throws IOException {
            // Start the layout processing service as a separate process
            return Runtime.getRuntime().exec("path_to_layout_executable");
        }
    }
}