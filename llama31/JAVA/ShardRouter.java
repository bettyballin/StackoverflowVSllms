import java.util.List;

public class ShardRouter {
  private List<String> shardUrls;
  
  public ShardRouter(List<String> shardUrls) {
    this.shardUrls = shardUrls;
  }
  
  public String getShardUrl(int customerId) {
    int shardIndex = customerId % shardUrls.size();
    return shardUrls.get(shardIndex);
  }

  public static void main(String[] args) {
    // Example usage
    ShardRouter shardRouter = new ShardRouter(List.of("shard1", "shard2", "shard3"));
    System.out.println(shardRouter.getShardUrl(1));
    System.out.println(shardRouter.getShardUrl(2));
    System.out.println(shardRouter.getShardUrl(3));
  }
}