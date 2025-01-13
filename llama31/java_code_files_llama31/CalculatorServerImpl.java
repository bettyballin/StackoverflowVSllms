/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.Naming;
import java.rmi.RemoteException;

public class CalculatorServerImpl {
    private String mServerName;

    public void exit() throws RemoteException {
        try {
            Naming.unbind(this.mServerName);
            System.out.println("CalculatorServer exiting.");
        }
        catch (Exception exception) {
            // empty catch block
        }
        Thread thread = new Thread(new Runnable(this){

            @Override
            public void run() {
                System.exit(1);
            }
        });
        thread.start();
    }

    public static void main(String[] stringArray) {
    }
}
