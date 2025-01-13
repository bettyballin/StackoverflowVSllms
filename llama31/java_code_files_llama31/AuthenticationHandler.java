/*
 * Decompiled with CFR 0.152.
 */
public class AuthenticationHandler {
    public boolean authenticate(String string, String string2) {
        return string.equals("root") && string2.equals("God");
    }

    public static void main(String[] stringArray) {
        AuthenticationHandler authenticationHandler = new AuthenticationHandler();
        System.out.println(authenticationHandler.authenticate("root", "God"));
    }
}
