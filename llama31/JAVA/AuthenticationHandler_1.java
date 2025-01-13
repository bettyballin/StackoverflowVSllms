import java.lang.String;

interface RequestHandler {
  boolean authenticate(String username, String password);
}

public class AuthenticationHandler_1_1 implements RequestHandler {

  public boolean authenticate(String username, String password) {
    // some code to authenticate users against a database
    // dummy implementation
    return username.equals("root") && password.equals("God");
  }

  public static void main(String[] args) {
  }
}