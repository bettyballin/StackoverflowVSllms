/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderSetter {
    public static void setResponseHeaders(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Pragma", "no-cache");
    }

    public static void main(String[] stringArray) {
    }
}
