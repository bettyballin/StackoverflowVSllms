import java.lang.String;

public class HelpSetLoader {
    ClassLoader classLoader = HelpSetLoader.class.getClassLoader();
    java.net.URL hsURL = classLoader.getResource("helpsets/helpset.hs");

    public static void main(String[] args) {
    }
}