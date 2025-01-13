import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main_378 {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            String soapEndpoint = (String) ctx.lookup("myApp/soapEndpoint");
            System.out.println(soapEndpoint);
        } catch (NamingException e) {
            System.out.println("Naming exception occurred: " + e.getMessage());
        }
    }
}