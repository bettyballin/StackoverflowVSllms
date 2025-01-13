import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

public class JBossContainerTest {
    // Create a test container
    JBossContainer container = new JBossContainer();
    String jndiName = "your_jndi_name"; // replace with your actual JNDI name

    public JBossContainerTest() throws Exception {
        container.start();

        // Use the data source from the test container
        InitialContext initialContext = container.getInitialContext();
        DataSource dataSource = (DataSource) initialContext.lookup(jndiName);
    }

    public static void main(String[] args) throws Exception {
        new JBossContainerTest();
    }
}