/*
 * Decompiled with CFR 0.152.
 */
public class DllRegistrar {
    public static void main(String[] stringArray) {
        try {
            Runtime.getRuntime().exec("regsvr32 /s youractivexdll.dll");
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
