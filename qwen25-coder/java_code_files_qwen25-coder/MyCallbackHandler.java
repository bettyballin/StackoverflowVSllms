import java.lang.String;
import javax.security.auth.callback.*;
import java.io.IOException;

public class MyCallbackHandler implements CallbackHandler {
    private String username;
    private char[] password;

    public MyCallbackHandler(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks)
            throws IOException, UnsupportedCallbackException {

        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                ((NameCallback) callbacks[i]).setName(username);
            } else if (callbacks[i] instanceof PasswordCallback) {
                ((PasswordCallback) callbacks[i]).setPassword(password);
            }
        }
    }

	public static void main(String[] args) {
	}
}