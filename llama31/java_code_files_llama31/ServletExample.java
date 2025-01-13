/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class ServletExample {
    public void doGet(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("application/x-server-response");
    }
}
