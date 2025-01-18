import java.lang.String;
public class Example_24 {
    private String value;

    public void fetchFromDB() throws Exception{  // better approach for long running operations
        Thread.sleep(1000); 	// mimic delay or db read
     }

    public String getValue(){   // simple property getter with no side effects
         return value;
     }

	public static void main(String[] args) {
	}
}