public class ExampleLooper {
    void methodName() {
        int i = 7;
        for (int j = 0; j < 10; j++) {
            int innerI = j * 2;
            // use innerI instead of i
        }
    }
    public static void main(String[] args) {
        ExampleLooper looper = new ExampleLooper();
        looper.methodName();
    }
}