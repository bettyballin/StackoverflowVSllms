import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class COMExample {
    public static void main(String[] args) {
        // Create an instance of the OTAClient object
        ActiveXComponent otaClient = new ActiveXComponent("TDAPIOLE80.TDConnection");

        try {
            // Connect to Quality Center
            Dispatch.put(otaClient, "Server", "http://qualitycenterserver/qcbin");
            Dispatch.put(otaClient, "UserName", "username");
            Dispatch.put(otaClient, "Password", "password");
            Dispatch.put(otaClient, "Domain", "DEFAULT");
            Dispatch.put(otaClient, "ProjectName", "PROJECT_NAME");
            
            // Connect method
            Variant connect = new Variant(true);
            Dispatch.call(otaClient, "Connect", connect);

            System.out.println("Connected...: " + otaClient.getProperty("Connected").toString());
            
            // Get the Defects list
            ActiveXComponent defects = new ActiveXComponent(Dispatch.get(otaClient, "BugFactory").toDispatch());

            // Add a defect (example)
            Variant addDefect = Dispatch.call(defects, "Add");
            Dispatch.put(addDefect.toDispatch(), "Name", "Sample Defect 1");
            Dispatch.put(addDefect.toDispatch(), "Description", "This is a sample defect.");
            
            Dispatch.call(addDefect.toDispatch(), "Post");

            System.out.println("Defect added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Disconnect
            if (otaClient != null) {
                Dispatch.call(otaClient, "Disconnect");
            }
        }
    }
}