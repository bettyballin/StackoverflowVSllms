/*
 * Decompiled with CFR 0.152.
 */
public class Permission {
    public static final int VIEWUSERS = 1;
    public static final int EDITUSERS = 2;

    public static int combinePermissions(int ... nArray) {
        int n = 0;
        for (int n2 : nArray) {
            n |= n2;
        }
        return n;
    }

    public static boolean hasPermission(int n, int n2) {
        return (n & n2) == n2;
    }

    public static void main(String[] stringArray) {
        int n = Permission.combinePermissions(1, 2);
        System.out.println(n);
        boolean bl = Permission.hasPermission(n, 2);
        System.out.println(bl);
    }
}
