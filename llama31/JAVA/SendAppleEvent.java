import java.lang.String;
import aeclient.AEClient;
import aeclient.AEEvent;

public class SendAppleEvent {
    public static void main(String[] args) {
        AEClient client = new AEClient("192.168.1.100", 3031); // replace with your MacOS 9 box's IP and port
        AEEvent event = new AEEvent("aevt", "odoc", "TEXT"); // create an event with the 'open document' command
        event.addParam("----", "file:///path/to/document.txt"); // add a parameter with the file path
        client.sendEvent(event);
        client.close();
    }
}