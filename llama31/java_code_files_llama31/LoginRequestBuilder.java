/*
 * Decompiled with CFR 0.152.
 */
public class LoginRequestBuilder {
    RequestBuilder requestBuilder = new RequestBuilder("POST", "/login");

    public LoginRequestBuilder() {
        this.requestBuilder.setHeader("Cookie", "sid=" + Cookies.getCookie("sid"));
    }

    public static void main(String[] stringArray) {
        new LoginRequestBuilder();
    }
}
