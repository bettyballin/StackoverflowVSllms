import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextInitializer {
    private static final String CONTEXT_FILE = "path/to/context/file.xml"; // replace with your actual context file path

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_FILE);
        context.setLazyInitBeans(false);
        context.refresh();
    }
}