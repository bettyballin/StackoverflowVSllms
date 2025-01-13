/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoteExceptionHandler {
    public Object doSomething() throws RemoteException {
        try {
            return this.getData();
        }
        catch (CustomException customException) {
            Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, customException.getCause());
            throw new RemoteException("Error occurred while processing request");
        }
    }

    public Object getData() throws CustomException {
        return null;
    }

    public static void main(String[] stringArray) {
    }
}
