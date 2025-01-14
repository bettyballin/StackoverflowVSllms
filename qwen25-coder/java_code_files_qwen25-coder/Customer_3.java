import java.lang.String;
public class Customer_3 {
    private String name;
    private CustomerType type;

    public Customer_3(String name, CustomerType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public CustomerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', type=" + type + "}";
    }

    public static void main(String[] args) {
    }
}