import java.lang.Integer;
import java.lang.String;
// import javax.validation.constraints.NotBlank;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface NotBlank {}

public class Child_1 {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    // Corrected dataType from Integer to int for age, or use @NotNull if it can be nullable
    private int age; 

    // getters and setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public static void main(String[] args) {
	}
}