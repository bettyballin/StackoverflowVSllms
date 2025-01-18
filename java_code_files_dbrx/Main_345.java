import org.apache.ignite.*;
import org.apache.ignite.cache.*;
import org.apache.ignite.cache.query.SqlQuery;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.configuration.*;
import org.apache.ignite.spi.discovery.tcp.*;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.*;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        // Set up Ignite context by configuring a new instance.
        Ignition.setClientMode(true); // true for connecting to an already running server node as cache client.

        IgniteConfiguration cfg = new IgniteConfiguration();

        // Configure the discovery SPI for node discovery.
        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509")); // Replace IPs and port range according to your setup.
        discoverySpi.setIpFinder(ipFinder);
        cfg.setDiscoverySpi(discoverySpi);

        Ignite ignite = Ignition.start(cfg);

        // Create an in-memory data grid cache which will hold your objects.
        CacheConfiguration<Integer, DataObject> configuration = new CacheConfiguration<>();
        configuration.setName("test_cache"); // Set the name for your cache.
        configuration.setIndexedTypes(Integer.class, DataObject.class); // Replace DataObject with your own class type representing each object in memory.

        // Get or create the "test_cache" cache instance.
        IgniteCache<Integer, DataObject> igniteDataObjCache = ignite.getOrCreateCache(configuration);

        // Store objects in the cache.
        igniteDataObjCache.put(1, new DataObject(1, "Value1")); // Store an object with identifier 1 in "test_cache"
        igniteDataObjCache.put(2, new DataObject(2, "Value2"));
        igniteDataObjCache.put(3, new DataObject(3, "Value3"));
        // ... Repeat for other objects to store them too.

        // Query your stored objects using SQL queries.
        SqlQuery<Integer, DataObject> sqlQuery = new SqlQuery<>(DataObject.class, "id > ? order by val");
        sqlQuery.setArgs(0);
        List<Entry<Integer, DataObject>> results = igniteDataObjCache.query(sqlQuery).getAll();

        // Display the query results.
        for (Entry<Integer, DataObject> entry : results) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        ignite.close();
    }
}

// Your DataObject class representing each object in memory.
public class DataObject {
    @QuerySqlField
    private int id;

    @QuerySqlField
    private String val;

    public DataObject() {
        // Default constructor.
    }

    public DataObject(int id, String val) {
        this.id = id;
        this.val = val;
    }

    // Getters and setters for Ignite's SQL queries.
    public int getId() {
        return id;
    }

    public String getVal() {
        return val;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DataObject{id=" + id + ", val='" + val + "'}";
    }
}