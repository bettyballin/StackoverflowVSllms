/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class Main_622 {
    public static void main(String[] stringArray) {
        HttpServletResponse httpServletResponse = Main_622.getServletResponse();
        if (httpServletResponse != null) {
            try {
                httpServletResponse.sendError(200);
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            System.out.println("HttpServletResponse is null");
        }
    }

    public static HttpServletResponse getServletResponse() {
        return null;
    }
}
