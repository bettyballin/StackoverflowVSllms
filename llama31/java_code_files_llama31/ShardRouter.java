/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class ShardRouter {
    private List<String> shardUrls;

    public ShardRouter(List<String> list) {
        this.shardUrls = list;
    }

    public String getShardUrl(int n) {
        int n2 = n % this.shardUrls.size();
        return this.shardUrls.get(n2);
    }

    public static void main(String[] stringArray) {
        ShardRouter shardRouter = new ShardRouter(List.of("shard1", "shard2", "shard3"));
        System.out.println(shardRouter.getShardUrl(1));
        System.out.println(shardRouter.getShardUrl(2));
        System.out.println(shardRouter.getShardUrl(3));
    }
}
