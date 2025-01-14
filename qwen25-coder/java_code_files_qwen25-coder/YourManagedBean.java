@interface Named {}
@interface RequestScoped {}

@Named
@RequestScoped
public class YourManagedBean {
    public String getString() {
        // Return your string here
        return "Hello from server!";
    }

    public static void main(String[] args) {
    }
}