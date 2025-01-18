import java.lang.String;
public class Example_23 {
    private String value; // property value fetched from DB or local cache based on conditions

    public Example_23() throws Exception { // fetch data in constructor
        Thread.sleep(1000);     // mimic delay or db read
        this.value = "fetched_data";
    }

    public String getValue() {   // simple property getter with no side effects
        return value;
    }

    public static void main(String[] args) {
    }
}