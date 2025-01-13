import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.DefaultHashAlgorithm;

public class Main_444 {
    public static void main(String[] args) {
        MemcachedClient client = null;
        try {
            client = new MemcachedClient(
                new BinaryConnectionFactory(),
                AddrUtil.getAddresses("server1:11211 server2:11211")
            );
            client.setHashAlgorithm(DefaultHashAlgorithm.KETAMA_HASH);
            // Perform operations with the client
        } catch (Exception e) {
            System.err.println("Error in client operation: " + e.getMessage());
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
    }
}