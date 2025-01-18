public class UserDataBuilder {
    private String name = "Default Name";
    private int age = 30; // default value
    private String email = "default@example.com"; // default value
    // ... setters & other default values and properties

    public UserDataBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserDataBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserDataBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CalculatorParameters build() {
        return new CalculatorParameters(name, age, email /* other fields or defaults */);
    }

    public static void main(String[] args) {
        UserDataBuilder builder = new UserDataBuilder();
        CalculatorParameters params = builder
            .setName("John Doe")
            .setAge(28)
            .setEmail("john.doe@example.com")
            .build();
        params.displayParameters();
    }
}

class CalculatorParameters {
    private String name;
    private int age;
    private String email;
    // ... other fields

    public CalculatorParameters(String name, int age, String email /* other parameters */) {
        this.name = name;
        this.age = age;
        this.email = email;
        // ... initialize other fields
    }

    public void displayParameters() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        // ... display other fields
    }
}