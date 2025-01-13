/*
 * Decompiled with CFR 0.152.
 */
public class Main_823 {
    public static void main(String[] stringArray) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkPermission(new RuntimePermission("exec"));
                System.out.println("Runtime.exec is allowed");
            }
            catch (SecurityException securityException) {
                System.out.println("Runtime.exec is not allowed");
            }
        } else {
            System.out.println("No SecurityManager, assuming Runtime.exec is allowed");
        }
    }
}
