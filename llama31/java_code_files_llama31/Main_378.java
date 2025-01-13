/*
 * Decompiled with CFR 0.152.
 */
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main_378 {
    public static void main(String[] stringArray) {
        try {
            InitialContext initialContext = new InitialContext();
            String string = (String)initialContext.lookup("myApp/soapEndpoint");
            System.out.println(string);
        }
        catch (NamingException namingException) {
            System.out.println("Naming exception occurred: " + namingException.getMessage());
        }
    }
}
