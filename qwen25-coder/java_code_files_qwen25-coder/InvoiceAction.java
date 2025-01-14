import java.util.ArrayList;
import java.util.List;

public class InvoiceAction {
    private List<LineItem> lineItems = new ArrayList<>();

    // Getter and setter for lineItems
    public List<LineItem> getLineItems() { return lineItems; }
    public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }

    public String execute() {
        // Process the list of line items
        System.out.println("Processing " + lineItems.size() + " line items.");
        for (LineItem item : lineItems) {
            System.out.println(item.getDescription() + ": $" + item.getAmount());
        }
        return "success";
    }

    // Other methods and fields as needed

    public static void main(String[] args) {
        // Main method code here
    }
}

class LineItem {
    private String description;
    private double amount;

    // Constructor
    public LineItem(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Getter methods
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
}