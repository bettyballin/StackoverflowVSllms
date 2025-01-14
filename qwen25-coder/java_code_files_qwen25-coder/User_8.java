import java.lang.String;
public class User_8 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

	public static void main(String[] args) {
	}
}