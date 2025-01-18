import java.util.Properties;

public class QuartzClusteringExample {
    public static void main(String[] args) {
        // Example code snippet for Quartz clustering with JDBC-Jobstore:

        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", "ClusterScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO"); // Auto generates unique id for each node in cluster
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", " org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.useProperties", "false"); // Use BLOBs for storing job data instead of text fields in DB tables. Better performance with large number of jobs/triggers.
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.isClustered", "true"); // Enables clustering feature within JDBC-Jobstore
    }
}