import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.HashSet;
import java.util.Set;

public class SessionInvalidator {

    public static void main(String[] args) throws Exception {
        // Set up JNDI context for connecting to the MBean server
        Context ctx = new InitialContext();
        MBeanServerConnection mbeanServerConn = (MBeanServerConnection) ctx.lookup("jmx/invoker/RMIAdaptor");

        // Define the ObjectName of the Manager MBean for your webapp
        String appPath = "/your-webapp"; // Replace with your application path
        ObjectName managerObjName = new ObjectName(String.format("jboss.web:type=Manager,path=%s,host=localhost", appPath));

        // Get all session ids from the manager
        Set<String> activeSessions = (Set<String>) mbeanServerConn.invoke(managerObjName, "listSessionIds", null, null);

        // Invalidate a specific session by its ID
        String sessionIdToInvalidate = "your_session_id"; // Replace with the session ID you want to invalidate
        if (activeSessions.contains(sessionIdToInvalidate)) {
            mbeanServerConn.invoke(managerObjName, "expireSession", new Object[]{sessionIdToInvalidate}, new String[]{"java.lang.String"});
            System.out.println("Session invalidated: " + sessionIdToInvalidate);
        } else {
            System.out.println("Session not found or already expired.");
        }
    }
}