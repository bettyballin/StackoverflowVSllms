/*
 * Decompiled with CFR 0.152.
 */
public class AuthenticationController {
    private AuthService authService = new AuthService();

    public String login(String string, String string2) {
        try {
            if (!this.authService.authenticate(string, string2)) {
                return "Invalid credentials";
            }
        }
        catch (UserNotFoundException userNotFoundException) {
            return "Invalid credentials";
        }
        return "Welcome, " + string;
    }

    public static void main(String[] stringArray) {
        AuthenticationController authenticationController = new AuthenticationController();
        System.out.println(authenticationController.login("test", "test"));
    }
}
