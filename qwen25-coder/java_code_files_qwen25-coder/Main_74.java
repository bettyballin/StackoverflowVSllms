public class Main {
    public static void main(String[] args) {
        String original = "hello";
        int length = 10;
        String padded = String.format("%" + length + "s", original).replace(' ', '*');
        System.out.println(padded); // Outputs: *****hello
    }
}