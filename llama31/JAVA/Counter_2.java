public class Counter_2_2 {
    boolean isHere = true; // or false, depending on your needs
    int index = 0; // or some other value, depending on your needs

    int count = isHere ? getHereCount(index) : getAwayCount(index);

    public static void main(String[] args) {
        new Counter_2();
    }

    private int getHereCount(int index) {
        // implementation of getHereCount method
        return 0; // placeholder value
    }

    private int getAwayCount(int index) {
        // implementation of getAwayCount method
        return 0; // placeholder value
    }
}