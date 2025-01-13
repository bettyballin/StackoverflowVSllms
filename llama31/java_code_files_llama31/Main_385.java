/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class Main_385 {
    public static void main(String[] stringArray) {
        HttpServletRequestMock httpServletRequestMock = new HttpServletRequestMock();
        String string = httpServletRequestMock.getServletPath();
        String string2 = httpServletRequestMock.getPathInfo();
        String string3 = httpServletRequestMock.getQueryString();
        try {
            URI uRI = new URI(null, null, string + string2, string3, null);
            String string4 = uRI.getRawPath() + "?" + uRI.getRawQuery();
            System.out.println(string4);
        }
        catch (URISyntaxException uRISyntaxException) {
            System.err.println("URISyntaxException caught: " + uRISyntaxException.getMessage());
        }
    }
}
