/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoteRequestHandler {
    public Object getData() throws CustomException {
        throw new CustomException("Something went wrong");
    }

    public Object doSomething() throws RemoteException {
        try {
            return this.getData();
        }
        catch (CustomException customException) {
            Logger.getLogger(RemoteRequestHandler.class.getName()).log(Level.SEVERE, null, customException);
            throw new RemoteException("Error occurred while processing request");
        }
    }

    public static void main(String[] stringArray) {
    }
}
