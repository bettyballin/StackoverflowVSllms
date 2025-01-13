import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MyClient_1_1 {
    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();
        MyRemoteInterface myRemote = (MyRemoteInterface) ctx.lookup("MyRMIService/remote");
        System.out.println(myRemote.sayHello());
    }
}