import java.util.List;
import java.util.ArrayList;

// Example pseudo-code for a simple stateful bean in Java EE (note: JAX-WS doesn't natively support this pattern)
@Stateful
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    @Remove
    @PreDestroy
    void cleanUp() {}

    public void addProduct(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
}

class TestShoppingCart {
    public static void main(String[] args) {
        // Code to test ShoppingCart
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product();
        cart.addProduct(product);
        List<Product> items = cart.getItems();
        System.out.println("Items in cart: " + items.size());
    }
}

// Define the Product class
class Product {
    // Product properties and methods
}

// Define the annotations
@interface Stateful {}

@interface Remove {}

@interface PreDestroy {}