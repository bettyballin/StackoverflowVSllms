/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MyServlet", urlPatterns={"/myService"})
public class MyServlet_13
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string;
        String string2 = httpServletRequest.getHeader("X-Forwarded-For");
        if (string2 != null && !string2.isEmpty()) {
            string = string2.split(",")[0].trim();
            if (!this.isValidIpAddress(string)) {
                System.out.println("Invalid IP address");
            }
        } else {
            System.out.println("Missing X-Forwarded-For header");
        }
        string = httpServletRequest.getHeader("Authorization");
        if (string != null && !string.isEmpty()) {
            if (!this.isValidToken(string)) {
                System.out.println("Invalid token");
            }
        } else {
            System.out.println("Missing token");
        }
    }

    private boolean isValidIpAddress(String string) {
        String[] stringArray = string.split("\\.");
        if (stringArray.length != 4) {
            return false;
        }
        for (String string2 : stringArray) {
            int n = Integer.parseInt(string2);
            if (n >= 0 && n <= 255) continue;
            return false;
        }
        return true;
    }

    private boolean isValidToken(String string) {
        return string.length() > 10;
    }

    public static void main(String[] stringArray) {
    }
}
