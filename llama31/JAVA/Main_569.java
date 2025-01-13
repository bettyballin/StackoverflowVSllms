import redis.clients.jedis.Jedis;

public class Main_569 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String username = jedis.get("session:username");
        System.out.println(username);
    }
}