/*
 * Decompiled with CFR 0.152.
 */
import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalHandlerExample {
    public static void main(String[] stringArray) {
        Signal.handle(new Signal("INT"), new SignalHandler(){

            @Override
            public void handle(Signal signal) {
                System.out.println("Received SIGINT signal");
            }
        });
        Signal.handle(new Signal("KILL"), new SignalHandler(){

            @Override
            public void handle(Signal signal) {
                System.out.println("Received SIGKILL signal");
            }
        });
    }
}
