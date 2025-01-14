import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterGroup;

public class MyIgniteApp {
    public static void main(String[] args) {
        // Start an Ignite node.
        Ignite ignite = Ignition.start();
        try {
            ClusterGroup clusterGroup = ignite.cluster();

            System.out.println("Node started: " + clusterGroup.localNode().id());
            System.out.println("Nodes count: " + clusterGroup.nodes().size());

            // Your logic here...
        } finally {
            ignite.close();
        }
    }
}