/*
 * Decompiled with CFR 0.152.
 */
public class ProgramDataDir {
    public static String getProgramDataDir() {
        String string = System.getProperty("os.name");
        if (string.startsWith("Windows")) {
            String string2 = System.getenv("PROGRAMDATA");
            if (string2 != null) {
                return string2;
            }
            return "C:\\ProgramData";
        }
        return null;
    }

    public static void main(String[] stringArray) {
        System.out.println(ProgramDataDir.getProgramDataDir());
    }
}
