import java.lang.String;
public class Example {
    private String name;

    public Example() {
        // 'name' is initialized as null by default
    }

    public void setName(String newName) {
        if (newName != null) {
            this.name = newName;
        } else {
            System.out.println("Null name provided, not setting.");
        }
    }

    public String getName() {
        return name == null ? "No name set" : name;
    }

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.getName()); // Outputs: No name set
        example.setName(null); // Prints a message instead of setting the name to null
        System.out.println(example.getName()); // Still outputs: No name set
    }
}