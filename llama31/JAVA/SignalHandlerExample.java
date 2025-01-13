import java.lang.String;
import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalHandlerExample {
    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("Received SIGINT signal");
                // Handle the signal
            }
        });

        Signal.handle(new Signal("KILL"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("Received SIGKILL signal");
                // Handle the signal
            }
        });
    }
}