/*
 * Decompiled with CFR 0.152.
 */
public class SessionTimeoutChecker {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        if (var1_1 != null) {
            if (System.currentTimeMillis() - var1_1.getLastAccessedTime() > (long)(var1_1.getMaxInactiveInterval() * 1000)) {
                System.out.println("Session is timed out");
            }
        } else {
            System.out.println("Session is null");
        }
    }
}
