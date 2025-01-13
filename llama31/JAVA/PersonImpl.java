// Define a simple model using EMF
public interface Person {
    String getName();
    void setName(String name);
}

public interface Address {
    String getStreet();
    void setStreet(String street);
}

// Generate Java code from the model using EMF's code generator
class PersonImpl implements Person {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class AddressImpl implements Address {
    private String street;

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }
}

// Use the generated code in your application
public class Example {
    public static void main(String[] args) {
        Person person = new PersonImpl();
        person.setName("John Doe");

        Address address = new AddressImpl();
        address.setStreet("123 Main St");

        System.out.println(person.getName());
        System.out.println(address.getStreet());
    }
}