import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public class MemcachedAddOperation {

    public static void main(String[] args) throws Exception {
        MemcachedClient memcachedClient = new MemcachedClient(
                new InetSocketAddress("127.0.0.1", 11211));
        Future<Boolean> result = memcachedClient.add("key", 0, "value");
        System.out.println(result.get());
    }
}