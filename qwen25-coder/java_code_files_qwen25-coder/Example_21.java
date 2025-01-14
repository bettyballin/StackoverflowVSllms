import java.lang.String;

public class Example_21 {
    public void process() {
        LargeObject obj = new LargeObject();
        // Use the object...

        // When done with obj, explicitly set it to null (optional)
        obj = null;
    }

    public static void main(String[] args) {
    }
}

class LargeObject {
    // Empty class definition to make the code executable
}