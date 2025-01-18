import akka.actor.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

interface App {
    // Interface methods (if any)
}

public class AkkaRemoteActorApplication implements App {
    public static void main(String[] args) throws UnknownHostException {
        // create an actor system for remoting with your RPC services
        ActorSystem system = ActorSystem.create("MyActorSystem");

        // get a reference to the remote node and look up an actor by path
        InetAddress remoteNode = InetAddress.getByName("127.0.0.1"); // Example IP address
        int PORT_NUMBER = 2552; // Example port number

        ActorSelection actorRef = system.actorSelection("akka://remote-node@" + remoteNode.getHostAddress()
                                     + ":" + PORT_NUMBER + "/user/actorName");
    }
}