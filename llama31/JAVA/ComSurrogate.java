import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ComSurrogate {
    public static void main(String[] args) {
        // Create a 64-bit wrapper process
        ActiveXComponent wrapper = new ActiveXComponent("COMWrapper.Wrapper");

        // Load the 32-bit COM object
        Dispatch comObject = wrapper.getObject("My32BitComObject");

        // Use the COM object as usual
        Variant result = comObject.invoke("MyMethod", "arg1", "arg2");
    }
}