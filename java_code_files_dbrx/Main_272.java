public class Main {
    public static void main(String[] args) throws Exception {
        // Assuming comObject is declared and initialized
        ComObject comObject = new ComObject();

        if (comObject == null) {
            throw new Exception("COM object not initialized");
        }
        // Code that uses the COM object goes here
    }
}

class ComObject {
    // Methods and properties of the COM object go here
}