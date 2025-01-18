import java.lang.String;
public class Example_25 {
    private String value; // property value

    public String getValue() throws Exception {   // long running process in getter
        Thread.sleep(1000); 	// mimic delay or db read
        return value;
    }

	public static void main(String[] args) {
	}
}