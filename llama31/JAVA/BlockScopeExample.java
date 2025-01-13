public class BlockScopeExample {
    {
        int x = 10; // x is only accessible within this block
        System.out.println(x);
    }
    // x is not accessible here
    public static void main(String[] args) {
        new BlockScopeExample();
    }
}