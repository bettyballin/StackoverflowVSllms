/*
 * Decompiled with CFR 0.152.
 */
public class VMChecker {
    public static void main(String[] stringArray) {
        if (System.getProperty("java.vm.name").equals("Dalvik")) {
            System.out.println("You are running on Dalvik VM");
        } else {
            System.out.println("You are running on a different VM");
        }
    }
}
