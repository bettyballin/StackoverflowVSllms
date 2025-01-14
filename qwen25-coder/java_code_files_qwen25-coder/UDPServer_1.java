import java.lang.String;
// Simplified example of server-side code for handling UDP messages (not including full hole punching logic)
import java.net.*;
import java.io.*;

public class UDPServer_1 {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(13456);
        byte[] receiveData = new byte[1024];
        
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            System.out.println("RECEIVED: " + sentence);

            // Process packets and help with hole punching (logic to be implemented)
        }
    }
}