import java.lang.String;
public class Foo_7 {
    private String field1 = "";
    private String field2 = "";

    // etc etc etc

    public void setField1(String field1) {
        this.field1 = (field1 != null) ? field1 : "";
    }

    public void setField2(String field2) {
        this.field2 = (field2 != null) ? field2 : "";
    }

    // etc for getters and other methods

	public static void main(String[] args) {
	}
}