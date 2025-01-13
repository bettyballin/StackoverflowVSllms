import java.lang.String;

public class LoginRequestBuilder {
    RequestBuilder requestBuilder;

    public LoginRequestBuilder() {
        requestBuilder = new RequestBuilder(RequestBuilder.POST, "/login");
        requestBuilder.setHeader("Cookie", "sid=" + Cookies.getCookie("sid"));
    }

    public static void main(String[] args) {
        new LoginRequestBuilder();
    }
}

class RequestBuilder {
    public static final String POST = "POST";
    private String method;
    private String path;

    public RequestBuilder(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public void setHeader(String key, String value) {
        // Implementation of setting a header
        System.out.println("Setting header: " + key + " = " + value);
    }
}

class Cookies {
    public static String getCookie(String name) {
        // Implementation of getting a cookie
        return "some-cookie-value";
    }
}