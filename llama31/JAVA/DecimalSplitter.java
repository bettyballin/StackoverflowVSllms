public class DecimalSplitter {
    public static void main(String[] args) {
        double value = 3.25;
        int whole = (int) value;
        double fractional = value - whole;

        System.out.println("Whole: " + whole);
        System.out.println("Fractional: " + fractional);
    }
}