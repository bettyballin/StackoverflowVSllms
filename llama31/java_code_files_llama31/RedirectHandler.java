/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class RedirectHandler {
    String url = "URL";
    HttpServletResponse response;

    public RedirectHandler(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public void sendRedirect() throws IOException {
        String string = this.response.encodeRedirectURL(this.url);
        this.response.sendRedirect(string);
    }

    public static void main(String[] stringArray) {
    }
}
