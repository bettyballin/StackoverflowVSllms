/*
 * Decompiled with CFR 0.152.
 */
public class TomcatRunner {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"java", "-agentpath:/path/to/yourkit/lib/yjpagent.jar", "-jar", "/path/to/tomcat/bin/bootstrap.jar"};
        try {
            Process process = Runtime.getRuntime().exec(stringArray2);
            process.waitFor();
        }
        catch (Exception exception) {
            System.err.println("Error running Tomcat: " + exception.getMessage());
        }
    }
}
