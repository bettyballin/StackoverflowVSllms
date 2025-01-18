import com.jacob.com.Dispatch;
import com.jacob.com.ComThread;
import com.jacob.com.DispatchEvents;
import com.jacob.com.Variant;

public class MainProgram {
    public static void main(String[] args) {
        Dispatch comObject = null;
        String myCLSID = "Your-CLSID-Here"; // Replace with your actual CLSID

        try {
            // start new thread from jacob as per DCOM activation rules.
            ComThread.InitSTA();
            comObject = new Dispatch(myCLSID);

            // Your code to interact with the COM object goes here

        } catch (Exception ex) {
            // Handle exception
            ex.printStackTrace();
        } finally {
            if (comObject != null) comObject.safeRelease();
            ComThread.Release();
        }
    }
}