/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    private HttpServletRequest request;

    public RequestUtil(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public String getReferrer() {
        return this.request.getHeader("referer");
    }

    public static void main(String[] stringArray) {
        HttpServletRequest httpServletRequest = null;
        RequestUtil requestUtil = new RequestUtil(httpServletRequest);
    }
}
