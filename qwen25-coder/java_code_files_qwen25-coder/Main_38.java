public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(i).append(" ");
            if (i % 1000 == 0) { // Print every 1000 iterations
                System.out.println(sb.toString());
                sb.setLength(0); // Clear the StringBuilder for reuse
            }
        }
        System.out.println(sb.toString()); // Print remaining data
    }
}