import java.io.*;
import java.net.*;

public class UdpFileClient {
    private static final String SERVER_HOST = "localhost"; // Set your server IP or host name here
    private static final int PORT = 5000;   // Set your desired communication port number to match with server's side setting
    private static final long FILESIZE = 13839472;   // File size used for sending packets, should be calculated on client side and passed along the network for file creation on a receiving end.

    public static void main(String args[]) throws Exception { // Send an existing file to another host by breaking it into byte segments which are sent over UDP with DatagramPackets as payload.
        File myFile = new File("filename.ext");    // Read local file
        Socket socket = new Socket(SERVER_HOST, PORT);  // Initiate communication socket towards a target host and port number
        byte[] mybytearray = new byte[(int) myFile.length()];  // Prepare buffer size large enough to hold the entire file
        
        // Read file contents into the byte array
        FileInputStream fis = new FileInputStream(myFile);  // Read file contents from local storage into an InputStream instance
        BufferedInputStream bis = new BufferedInputStream(fis);   // Wrap input stream with buffer for more efficient reading
        bis.read(mybytearray, 0, mybytearray.length);  // Read entire data from the file into the array
        bis.close();  // Close input streams after reading
        
        // Send the file over UDP
        DatagramSocket datagramSocket = new DatagramSocket(); // Create a datagram socket for sending packets
        InetAddress address = InetAddress.getByName(SERVER_HOST); // Get the target host IP address
        DatagramPacket sendPack = new DatagramPacket(mybytearray, mybytearray.length, address, PORT);  // Create a datagram packet to send
        
        datagramSocket.send(sendPack);  // Send the packet over the network to the destination
        datagramSocket.close(); // Close the datagram socket
        socket.close(); // Close the TCP socket if it's no longer needed
    }
}