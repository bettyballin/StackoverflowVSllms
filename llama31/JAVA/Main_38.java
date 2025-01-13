public class Main_38 {
    public static void main(String[] args) {
        int num = 0;
        try {
            assert num > 0 : "The number must be greater than zero!";
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
    }
}