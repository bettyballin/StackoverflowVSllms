import java.lang.String;
import java.lang.Integer;
import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: java UDPClient server_host port filename");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        String fileName = args[2];

        InetAddress ipAddress = InetAddress.getByName(hostname);
        DatagramSocket clientSocket = new DatagramSocket();

        // Request the file
        byte[] requestPacketData = fileName.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(requestPacketData, requestPacketData.length, ipAddress, port);
        clientSocket.send(sendPacket);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fileName));
            boolean morePackets = true;

            while (morePackets) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String receivedStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if (receivedStr.startsWith("file not found")) {
                    System.out.println("File not found on the server.");
                    morePackets = false;
                } else {
                    fos.write(receivePacket.getData(), 0, receivePacket.getLength());
                    fos.flush();

                    // For simplicity, we assume packets are received in order and no loss occurs.
                    // In a real-world scenario, acknowledgment should be sent to server for each packet received,
                    // and the server should retransmit lost packets.
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (fos != null) fos.close();
        }

        clientSocket.close();
    }
}