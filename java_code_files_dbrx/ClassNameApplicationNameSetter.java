import java.lang.String;
public class ClassNameApplicationNameSetter {
    static {
        System.setProperty("sun.java.command", "MyDesiredAppName");
    }
    public static void main(String[] args) {
    }
}