/*
 * Decompiled with CFR 0.152.
 */
public class ProgramExecutor {
    public static void main(String[] stringArray) {
        try {
            Runtime.getRuntime().exec("path/to/your/vb/program.exe");
        }
        catch (Exception exception) {
            System.out.println("Error executing program: " + exception.getMessage());
        }
    }
}
