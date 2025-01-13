import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.StringWriter;

// Define Customer class
class Customer {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

// Define Order class
class Order {
    private Date estimatedDispatchDate;

    public Order(Date estimatedDispatchDate) {
        this.estimatedDispatchDate = estimatedDispatchDate;
    }

    public Date getEstimatedDispatchDate() {
        return estimatedDispatchDate;
    }
}

// Define TemplatingExample class with main method
public class TemplatingExample_1 {
    public static void main(String[] args) throws Exception {
        // Create a Freemarker configuration
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDirectoryForTemplateLoading(new java.io.File(".")); // Specify the directory where the template file is located

        // Create a context
        Map<String, Object> root = new HashMap<>();
        Customer customer = new Customer("John", "Doe");
        Order order = new Order(new Date());
        root.put("customer", customer);
        root.put("order", order);

        // Create a template
        Template template = cfg.getTemplate("template.ftl");

        // Process the template
        StringWriter writer = new StringWriter();
        template.process(root, writer);

        // Print the result
        System.out.println(writer.toString());
    }
}