import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User_14 {
    @NotNull
    private String name;

    @Min(18)
    private int age;

    // Getters and setters...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}