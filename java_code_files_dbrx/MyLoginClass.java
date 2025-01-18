import java.util.Date;

public class MyLoginClass {

    private LoginService loginService;
    private TextBox loginTxT;
    private TextBox passTXT;
    private String sessionId;

    public void login() {

        loginService.authenticateUser(
            loginTxT.getText(),
            passTXT.getText(),
            new AsyncCallback<Boolean>() {
                public void onFailure(Throwable caught) {
                    // handle failure
                }
                public void onSuccess(Boolean sessionIsValidForLoggedInUser) {
                    if (sessionIsValidForLoggedInUser){
                        final long DURATION = 1000 * 60 * 3; // duration for cookie to be kept in client
                        Date expire = new Date(System.currentTimeMillis() + DURATION);
                        // set the jsessionid as a cookie along with its valid duration
                        Cookies.setCookie("JSESSIONID", sessionId, expire);
                    }
                }
            }
        );
    }
}

interface LoginService {
    void authenticateUser(String username, String password, AsyncCallback<Boolean> callback);
}

class TextBox {
    public String getText() {
        return ""; // Return empty string for simplicity
    }
}

interface AsyncCallback<T> {
    void onFailure(Throwable caught);
    void onSuccess(T result);
}

class Cookies {
    public static void setCookie(String name, String value, Date expires) {
        // Implementation
    }
}