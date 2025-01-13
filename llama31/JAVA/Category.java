import java.util.List;
import java.util.ArrayList;

public class Category {
    private int id;
    private String name;
    private List<Product> products;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public List<Product> getProductsByGroup(int groupId) {
        // retrieve products from database or other data source
        // filter products by groupId
        // for simplicity, just return all products
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public static void main(String[] args) {
        Category category = new Category(1, "Example Category");
        Product product = new Product(1, "Example Product", category);
        category.addProduct(product);
        List<Product> products = category.getProductsByGroup(1);
        System.out.println(products.size()); // prints 1
    }
}