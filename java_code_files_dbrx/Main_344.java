public class Main {
    public static void main(String[] args) {
        // assuming 'doc' is an instance that supports 'Quit' operation.
        Dispatch doc = null;

        Dispatch.call(doc, "Quit");
    }
}

class Dispatch {
    public static void call(Object dispatch, String methodName) {
        // Placeholder method to make the code executable
    }
}