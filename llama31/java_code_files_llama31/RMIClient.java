/*
 * Decompiled with CFR 0.152.
 */
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RMIClient {
    public static void main(String[] stringArray) {
        try {
            InitialContext initialContext = new InitialContext();
            RemoteInterface remoteInterface = (RemoteInterface)initialContext.lookup("SessionBean#RemoteInterface");
            remoteInterface.myMethod();
        }
        catch (NamingException namingException) {
            System.out.println("NamingException caught: " + namingException.getMessage());
        }
    }
}
