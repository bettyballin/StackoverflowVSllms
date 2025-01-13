// Assuming you have a Java DTO class named "User"
public class User_14 {
    private String name;
    private String email;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Using the Granite Data Services utility
import org.granite.generator.as3.As3Generator;
import org.granite.generator.as3.reflect.JavaClass;

public class Main {
    public static void main(String[] args) {
        JavaClass javaClass = new JavaClass(User.class);
        As3Generator generator = new As3Generator(javaClass);
        String flexCode = generator.generate();
        System.out.println(flexCode);
    }
}