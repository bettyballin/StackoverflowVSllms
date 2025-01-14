import java.lang.String;
import java.lang.Integer;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class UDPServer {
    private static final int MAX_PAYLOAD_SIZE = 1024;

    public static void main(String args[]) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java UDPServer port");
            return;
        }

        int serverPort = Integer.parseInt(args[0]);
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        byte[] receiveData = new byte[MAX_PAYLOAD_SIZE];
        byte[] sendData;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Wait to receive request
            serverSocket.receive(receivePacket);
            String requestedFile = new String(receivePacket.getData(), 0, receivePacket.getLength());

            InetAddress IPAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            try {
                File fileToSend = new File(requestedFile);

                if (!fileToSend.exists() || !fileToSend.isFile()) {
                    sendData = "file not found".getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
                    serverSocket.send(sendPacket);
                    continue;
                }

                // Read file and send it over UDP
                FileInputStream fis = new FileInputStream(fileToSend);
                int bytesRead;

                while ((bytesRead = fis.read(receiveData)) != -1) {
                    sendData = Arrays.copyOfRange(receiveData, 0, bytesRead);
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
                    serverSocket.send(sendPacket);
                }
                fis.close();
            } catch (Exception e) {
                System.err.println("Error handling request: " + e.getMessage());
                continue;
            }
        }
    }
}