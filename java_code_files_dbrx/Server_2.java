import java.lang.String;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server_2 {
    private volatile boolean running = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server_2 server = new Server_2();
        server.initialize();
    }

    private void initialize() throws IOException, InterruptedException {
        ServerSocket s;
        Socket socket;
        InputStream is;
        OutputStream os;
        DataInputStream dis;
        DataOutputStream dos;

        try (ServerSocket serverSocket = new ServerSocket(4448)) {
            while (!Thread.currentThread().isInterrupted() && running) { //ADDITION HERE!
                socket = serverSocket.accept(); // block until client connects
                is = socket.getInputStream();
                os = socket.getOutputStream();
                dis = new DataInputStream(is);
                dos = new DataOutputStream(os);

                try {
                    while (true) { //read data forever if available
                        byte input = dis.readByte();
                        System.out.println("READ: " + input);
                        /* If client sends close message, gracefully end connection */
                        if(input == -1){
                            dos.writeInt(-1); // send response to confirm closing
                            socket.close();
                            break; //break the while loop
                        } else {
                            System.out.println("WRITING RESPONSE...");
                            dos.writeByte((byte) -input); //send response if not closed
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace(); //log/investigate error
                    /* Close streams and socket on exception */
                    dos.close();
                    dis.close();
                    socket.close();
                } finally {
                    /* ALWAYS CLOSE IN FINALLY */
                    if(dos != null) dos.close();
                    if(dis != null) dis.close();
                    if(!socket.isClosed()) socket.close(); //check not closed before trying to close
                }
            }
        } finally {
            /* Always interrupt/stop thread and cleanup when main server is done */
            running = false;
            Thread.currentThread().interrupt();
        }
    }
}