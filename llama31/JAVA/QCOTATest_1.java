import net.sf.jinterop.dcom.core.JIComServer;
import net.sf.jinterop.dcom.impls.JIComServerFactory;

public class QCOTATest_1_1 {
    public static void main(String[] args) {
        // Create a COM server instance
        JIComServer comServer = JIComServerFactory.createInstance();

        // Get a reference to the QC OTA API
        Object qcApp = comServer.createObject("QCApplication");

        // Call a method on the QC OTA API
        comServer.invoke(qcApp, "Login", "username", "password");

        // Release resources
        comServer.destroyObject(qcApp);
    }
}