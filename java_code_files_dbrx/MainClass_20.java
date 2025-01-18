public class MainClass {
    public static void main(String[] args) {
        boolean allowLogin = true; // suppose boolean coming from outside source
        if (allowLogin) login();  // This can lead to unexpected user being logged in or logging in even when some checks have failed if false was expected but received true due to malicious injection of value.
        // This shows the danger of using booleans without proper checks especially considering they might be getting their values from an external source which might not be what you expect it to be.
    }

    public static void login() {
        // Login logic here
        System.out.println("User logged in.");
    }
}