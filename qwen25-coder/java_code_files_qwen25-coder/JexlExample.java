import java.lang.String;
import java.time.LocalDate;
import java.io.StringWriter;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JxltEngine;
import org.apache.commons.jexl3.MapContext;

public class JexlExample {
    public static void main(String[] args) {
        // Create a JEXL engine
        JexlEngine jexl = new JexlBuilder().create();
        JxltEngine jxlt = jexl.createJxltEngine();

        // Prepare some data (e.g., customer and order)
        Customer customer = new Customer("John", "Doe");
        Order order = new Order(LocalDate.now().plusDays(3));

        // Create a context and put the data in it
        JexlContext context = new MapContext();
        context.set("customer", customer);
        context.set("order", order);

        // Define your template
        String template = "Dear ${customer.firstName}. Your order will be dispatched on ${order.estimatedDispatchDate}";

        // Create a template out of the string
        JxltEngine.Template t = jxlt.createTemplate(template);

        // Evaluate it
        StringWriter writer = new StringWriter();
        t.evaluate(context, writer);

        String result = writer.toString();

        System.out.println(result);
    }
}

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class Order {
    private LocalDate estimatedDispatchDate;

    public Order(LocalDate estimatedDispatchDate) {
        this.estimatedDispatchDate = estimatedDispatchDate;
    }

    public String getEstimatedDispatchDate() {
        return estimatedDispatchDate.toString();
    }

    // Optionally format the date as needed
}