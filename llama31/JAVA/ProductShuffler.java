import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Product {
    // Add your Product class implementation here
}

public class ProductShuffler {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); 
        // fetch all products from database and add to the products list
        Collections.shuffle(products); // shuffle the list
        // paginate the shuffled list
    }
}