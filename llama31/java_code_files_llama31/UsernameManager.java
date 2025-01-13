/*
 * Decompiled with CFR 0.152.
 */
public class UsernameManager {
    private static Object lock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void manageUsername(String string) {
        Object object = lock;
        synchronized (object) {
            if (UsernameManager.usernameExists(string)) {
                System.out.println("Username already exists.");
            } else {
                UsernameManager.insertUsername(string);
            }
        }
    }

    private static boolean usernameExists(String string) {
        return false;
    }

    private static void insertUsername(String string) {
        System.out.println("Username inserted: " + string);
    }

    public static void main(String[] stringArray) {
        UsernameManager.manageUsername("testUser");
    }
}
