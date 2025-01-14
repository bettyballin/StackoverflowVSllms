import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.ConnectionFactoryBuilder.Locator;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemcachedExample {
    public static void main(String[] args) throws Exception {
        // Use Ketama consistent hashing with BINARY protocol
        MemcachedClient mc = new MemcachedClient(
            new ConnectionFactoryBuilder()
                .setProtocol(Protocol.BINARY)
                .setLocatorType(Locator.CONSISTENT)
                .build(),
            AddrUtil.getAddresses("127.0.0.1:11211"));
    }
}