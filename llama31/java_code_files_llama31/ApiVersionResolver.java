/*
 * Decompiled with CFR 0.152.
 */
public class ApiVersionResolver {
    public static void main(String[] stringArray) {
        String string;
        Request request = new Request("v2", null);
        String string2 = string = request.getHeader("X-API-Version") != null ? request.getHeader("X-API-Version") : request.getParameter("version");
        if (string == null) {
            string = "v1";
        }
        System.out.println("Version: " + string);
    }
}
