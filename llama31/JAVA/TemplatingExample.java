import java.lang.String;
import java.util.Date;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

public class TemplatingExample {
    public static void main(String[] args) {
        ExpressionFactory factory = ExpressionFactory.newInstance();

        // Create a context
        VariableMapper variableMapper = new VariableMapper();
        Customer customer = new Customer("John", "Doe");
        Order order = new Order(new Date());
        variableMapper.setVariable("customer", factory.createValueExpression(customer, Customer.class));
        variableMapper.setVariable("order", factory.createValueExpression(order, Order.class));

        // Create a template
        String template = "Dear ${customer.firstName}. Your order will be dispatched on ${order.estimatedDispatchDate}";

        // Replace placeholders with actual values
        String formattedMessage = template;
        for (String var : variableMapper.getVariables()) {
            ValueExpression expr = variableMapper.resolveVariable(var);
            Object value = expr.getValue(expr.getExpectedType());
            if (value instanceof Customer) {
                Customer c = (Customer) value;
                formattedMessage = formattedMessage.replace("${" + var + ".firstName}", c.getFirstName());
            } else if (value instanceof Order) {
                Order o = (Order) value;
                formattedMessage = formattedMessage.replace("${" + var + ".estimatedDispatchDate}", String.valueOf(o.getEstimatedDispatchDate()));
            }
        }

        System.out.println(formattedMessage);
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

    public String getLastName() {
        return lastName;
    }
}

class Order {
    private Date estimatedDispatchDate;

    public Order(Date estimatedDispatchDate) {
        this.estimatedDispatchDate = estimatedDispatchDate;
    }

    public Date getEstimatedDispatchDate() {
        return estimatedDispatchDate;
    }
}