import java.lang.String;
public class ExampleClass_2 {
    private String name; //this is a field
    private int id;      //this is another field

    //property methods (getter, setter) for "name" and "id" fields.
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(!name.isEmpty()) {  //validation check
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public int getId() {
	return this.id;
    }

	public static void main(String[] args) {
	}
}