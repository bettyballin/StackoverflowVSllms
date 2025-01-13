import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextConfigurer {
    private static final String CONTEXT_FILE = "path_to_your_context_file.xml"; // replace with your actual context file

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_FILE);
        context.setAllowBeanDefinitionOverriding(false);
    }
}