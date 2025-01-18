public class MainClass {
    public static void main(String[] args) {
        boolean result = new MainClass().getClass().getResourceAsStream("/map.mp") != null;
        System.out.println(result);
    }
}