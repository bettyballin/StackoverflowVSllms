import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import java.util.List;

public class UserForm {

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Size(min = 6, max = 15, message = "Password must be between 6 and 15 characters")
    private String password;

    @Valid // Ensures that each element in the list will also be validated
    private List<Address> addresses;

    // Getters and setters

    public String getName() {
        return name;
    }   

    public void setName(String name) {
        this.name = name;
    }   

    public String getPassword() {
        return password;
    }   

    public void setPassword(String password) {
        this.password = password;
    }   

    public List<Address> getAddresses() {
        return addresses;
    }   

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

// Address class
import javax.validation.constraints.NotEmpty;

class Address {

    @NotEmpty(message = "Street is mandatory")
    private String street;

    @NotEmpty(message = "City is mandatory")
    private String city;

    // Getters and setters

    public String getStreet() {
        return street;
    }   

    public void setStreet(String street) {
        this.street = street;
    }   

    public String getCity() {
        return city;
    }   

    public void setCity(String city) {
        this.city = city;
    }
}