import java.lang.String;
public class ProcessNameChanger_1 {
    public static void main(String[] args) throws Exception {
        if (System.getProperty("os.name").contains("Linux")) {
            // Warning: This is a hack and may not work or be stable across all Java versions and JVMs.
            final char[] newProcName = "MyProgram".toCharArray();
            Runtime.getRuntime().exec(new String[]{"bash", "-c", "ps aux | grep Myprogram"});
            System.arraycopy(newProcName, 0, args[0].toCharArray(), 0, Math.min(args[0].length(), newProcName.length));
        }
    }
}