/*
 * Decompiled with CFR 0.152.
 */
public class ExitStatusChecker {
    private boolean success;

    public int run() {
        if (!this.success) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] stringArray) {
        ExitStatusChecker exitStatusChecker = new ExitStatusChecker();
        exitStatusChecker.success = true;
        System.out.println(exitStatusChecker.run());
    }
}
