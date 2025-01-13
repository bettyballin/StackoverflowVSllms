/*
 * Decompiled with CFR 0.152.
 */
public class JVMInfo {
    public static void main(String[] stringArray) {
        String string = System.getProperty("java.vm.vendor");
        String string2 = System.getProperty("java.vm.version");
        System.out.println("JVM Vendor: " + string);
        System.out.println("JVM Version: " + string2);
    }
}
