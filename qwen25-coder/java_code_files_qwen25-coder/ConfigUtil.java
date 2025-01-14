import java.lang.String;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConfigUtil {
   public String getSOAPEndpoint() throws NamingException {
       InitialContext ctx = new InitialContext();
       return (String) ctx.lookup("java:comp/env/soap/endpoint");
   }

   public static void main(String[] args) {
   }
}