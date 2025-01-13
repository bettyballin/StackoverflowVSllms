/*
 * Decompiled with CFR 0.152.
 */
public class Main_390 {
    public static void main(String[] stringArray) {
        HttpServletRequest httpServletRequest = new HttpServletRequest();
        if (httpServletRequest != null) {
            String string;
            String string2 = httpServletRequest.getRequestURI();
            String string3 = string2 + "?" + (string = httpServletRequest.getQueryString());
            int n = string3.indexOf("#");
            if (n != -1) {
                String string4 = string3.substring(n + 1);
                System.out.println(string4);
            }
        } else {
            System.out.println("HttpServletRequest object is null");
        }
    }
}
