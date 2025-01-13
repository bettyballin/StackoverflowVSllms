import java.lang.String;

public class AuthenticationHandler {
  public boolean authenticate(String username, String password) {
    // some code to authenticate users against a database
    // dummy implementation
    return username.equals("root") && password.equals("God");
  }

  public static void main(String[] args) {
    AuthenticationHandler handler = new AuthenticationHandler();
    System.out.println(handler.authenticate("root", "God")); // prints: true
  }
}