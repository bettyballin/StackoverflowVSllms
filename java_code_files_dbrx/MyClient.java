import java.lang.String;
import java.io.*;
import java.net.*;
public class MyClient {
  public static void main(String[] args) throws IOException, InterruptedException {
    String serverName = "localhost";
    int port = 8000;

    System.out.println("Connecting to " + serverName + " on port " + port);
    Socket client = new Socket(serverName, port);

    System.out.println("Just connected to: " +client.getRemoteSocketAddress());

    OutputStream outToServer = client.getOutputStream();
    DataOutputStream out = new DataOutputStream(outToServer);
    out.writeUTF("Hello from: " + client.getLocalSocketAddress()+" I'm going down now");
    Thread.sleep(5000); //wait for 5s to mimic the server-client communication scenario
    client.close(); //here closing the socket simulating a network disconnect issue.
  }
}