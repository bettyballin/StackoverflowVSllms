import java.lang.String;

public class JettyServletResponseConfigurator {
    static {
        System.setProperty("org.eclipse.jetty.servlet.ServletResponseWrapper", "org.apache.jasper.runtime.HttpServletResponseWrapper");
    }

    public static void main(String[] args) {
    }
}