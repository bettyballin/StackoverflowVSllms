public class Main {
    public static void main(String[] args) {
        String original = "world";
        int length = 10;
        String paddedLeft = String.format("%-" + length + "s", original).replace(' ', '*');
        System.out.println(paddedLeft); // Outputs: world*****
    }
}