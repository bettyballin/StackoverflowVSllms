import java.io.*;
import java.net.*;

public class UdpFileServer {
    private static final int PORT = 1234; // Set your own port number here
    private static final int BUFSIZE = 65507; // Maximum size of a single datagram, ~65k - IP/UDP overheads

    public static void main(String args[]) {
        try {
            DatagramSocket serverSock = new DatagramSocket(PORT);
            byte[] buffer = new byte[BUFSIZE];

            while (true) { // Run until manually stopped or an exception is thrown.
                System.out.println("Server ready, waiting for clients to send files...");
                DatagramPacket incomingFile = new DatagramPacket(buffer, buffer.length); // Create a datagram packet to receive the file in
                serverSock.receive(incomingFile);

                InputStream inStream = new ByteArrayInputStream(incomingFile.getData());    // Parse received packets and store them as bytes in an array
                DataInputStream dataIn = new DataInputStream(inStream);    // Wrap input stream with a DataInput

                String filename = dataIn.readUTF();
                long fileLength = dataIn.readLong(); // File length is passed along these packets for further use at the receiving side

                System.out.println("Received file " + filename);
                File outputFile = new File(filename);

                if (!outputFile.exists()) {  // Check if file exists, create a new one if it does not.
                    try {
                        boolean success = outputFile.createNewFile();
                    } catch (IOException ex) {
                        // Handle exception here.
                        ex.printStackTrace();
                    }
                } else if (outputFile.isDirectory()) { // If the file exists and is a directory, create another filename with timestamp appendage
                    System.out.println(filename + " already exists, overwriting it ....");
                }

                FileOutputStream outStream = new FileOutputStream(outputFile);

                long bytesReceived = 0; // Number of received bytes counter
                try {
                    while (bytesReceived < fileLength) {   // Loop until all the bytes has been read.
                        int bytesToRead = BUFSIZE;
                        if ((bytesReceived + bytesToRead) > fileLength) {
                            // if we're at the end of the stream, adjust to avoid over-run
                            bytesToRead = (int)(fileLength - bytesReceived);
                        }
                        byte[] tmpBuffer = new byte[bytesToRead];  // Create temporary buffer with size equal to the amount of pending unread bytes from input stream.
                        dataIn.readFully(tmpBuffer, 0, bytesToRead);   // Read as long as there's data left in the DataInput until reaching end of file or an exception is thrown
                        outStream.write(tmpBuffer, 0, bytesToRead);    // Write new byte segment to a file with FileOutputStream from the above read temporary buffer.

                        bytesReceived += bytesToRead;  // Increase received byte counter for next round in loop
                    }
                    System.out.println("Bytes received: " + bytesReceived);
                } catch (IOException ex) {
                    // Handle exception caused by bad file or input stream
                    ex.printStackTrace();
                } finally { // Always clean up our FileOutputStream and InputStream instances to prevent possible memory leak issues.
                    outStream.flush();
                    outStream.close();
                }
            }
        } catch (IOException ex) { // Handle exception if socket failed to bind or port was already in use by another application.
            System.out.println("Server could not listen on " + PORT);
            ex.printStackTrace();
        }
    }
}