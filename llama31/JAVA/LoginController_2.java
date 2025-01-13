import java.lang.String;

public class LoginController_2_2 {
    RpcRequestBuilder rpcRequestBuilder = new RpcRequestBuilder();

    public LoginController_2() {
        rpcRequestBuilder.setHeader("Cookie", "sid=" + Cookies.getCookie("sid"));
        loginService.authenticateUser(loginTxt.getText(), passTxt.getText(), rpcRequestBuilder);
    }

    public static void main(String[] args) {
        new LoginController_2();
    }
}