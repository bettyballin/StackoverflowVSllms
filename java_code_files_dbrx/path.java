import java.util.ArrayList;

public class path {
    public static void main(String[] args) {
        String path = "java"; // this is your java executable
        String classpath = System.getProperty("java.class.path"); // class path set to java's current classpath

        ArrayList<String> commandWithArgs = new ArrayList<>();
        commandWithArgs.add(path); // this is your java executable
        commandWithArgs.add("-cp"); // classpath directive
        commandWithArgs.add(classpath); // class path set to java's current classpath
        commandWithArgs.add("javaOption1");
        commandWithArgs.add("javaValue1"); // your extra command-line arguments goes here.
        commandWithArgs.add(AnotherClassWithMainMethod.class.getName()); // your main class that should be run in secondary/child JVM.
        ProcessBuilder processBuilder = new ProcessBuilder(commandWithArgs);
    }
}