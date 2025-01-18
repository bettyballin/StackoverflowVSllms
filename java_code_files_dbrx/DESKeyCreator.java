import java.lang.String;
import javax.crypto.spec.SecretKeySpec;

public class DESKeyCreator {
    String password = "password";         //8 character string; This example will fail for <7 char strings
    byte[] rawKey = password.getBytes();   //Get the bytes into a Byte array
    SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "DES");       //Translate to Secret Key

    public static void main(String[] args) {
    }
}