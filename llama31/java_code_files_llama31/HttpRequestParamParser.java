/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestParamParser {
    public void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try (ServletInputStream servletInputStream = httpServletRequest.getInputStream();){
            String[] stringArray;
            String string = new String(servletInputStream.readAllBytes());
            for (String string2 : stringArray = string.split("&")) {
                String[] stringArray2 = string2.split("=");
                if (stringArray2.length != 2 || !stringArray2[0].equals("name")) continue;
                String string3 = stringArray2[1];
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public static void main(String[] stringArray) {
    }
}
