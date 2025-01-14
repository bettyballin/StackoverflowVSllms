public class CustomerRenderer {
    void renderSearch(Customer c) {
        System.out.println("search customer rendering>...");
        try {
            if (c != null) {
                System.out.println("search customer found...");
            } else {
                System.out.println("search customer not found...");
            }
        } catch (Exception e) {
            System.err.println("search customer rendering error: " + e.getMessage() + "-" + e.getClass());
        }
    }

    public static void main(String[] args) {
    }
}

class Customer {
    // Empty class
}