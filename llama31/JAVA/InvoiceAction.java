import java.util.ArrayList;
import java.util.List;

// Define the SUCCESS constant
interface ActionSupport {
    String SUCCESS = "success";
}

public class InvoiceAction extends ActionSupport {
    private List<LineItem> lineItems = new ArrayList<>();

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String execute() throws Exception {
        // Process the line items here
        return SUCCESS;
    }

    public static void main(String[] args) {
    }
}

class LineItem {
    private String name;
    private double amount;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}