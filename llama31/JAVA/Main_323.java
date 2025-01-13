import org.jboss.management.ManagementClient;
import org.jboss.management.ManagementClientFactory;

public class Main_323 {
    public static void main(String[] args) throws Exception {
        // Create a ManagementClient
        ManagementClient client = ManagementClientFactory.createClient();

        // Get the JBossManager MBean
        Object[] params = new Object[] { "your_session_id" };
        Object result = client.invoke("jboss.web:type=Manager,path=/your/webapp/context", "invalidateSession", params, null);
        System.out.println(result);
    }
}