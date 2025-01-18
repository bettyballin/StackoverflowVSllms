class COMObject {
    public int MethodCall() {
        // Implementation goes here
        return 0; // Placeholder return value
    }
}

public class MyProgram {
    public static void main(String[] args) throws Exception {
        // Assuming comObject is an instance of some class that has MethodCall()
        COMObject comObject = new COMObject();
        int result = comObject.MethodCall();
        if (result < 0) { // replace with appropriate error condition
            throw new Exception("Error occurred in MethodCall");
        }
        // Code that uses the COM object goes here
    }
}