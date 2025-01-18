import org.bouncycastle.bcpg.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Main {
    public static void main(String[] args) {
        // Additional code here...
        Security.addProvider(new BouncyCastleProvider());
    }
}