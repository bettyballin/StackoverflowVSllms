/*
 * Decompiled with CFR 0.152.
 */
public class Main_151 {
    public static void main(String[] stringArray) {
        HttpServletRequest httpServletRequest = new HttpServletRequest("This is the request body.");
        String string = HttpServletRequestHelper.getBody(httpServletRequest);
        System.out.println(string);
    }
}
