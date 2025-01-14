public class HtmlMessageBuilder {

    // Assuming 'product' and 'EscapeUtils' are defined elsewhere
    Product product = new Product();

    String safeMessage = "Title created successfully with product number: <a href=\"http://www.example.com\">"
            + EscapeUtils.escapeHtml4(product.getProductNumber()) + "</a>.";

    {
        createMessage(safeMessage);
    }

    public void createMessage(String message) {
        // Implementation here
    }

    public static void main(String[] args) {
    }
}

class Product {
    public String getProductNumber() {
        return "12345";
    }
}

class EscapeUtils {
    public static String escapeHtml4(String input) {
        // Implementation here
        return input;
    }
}