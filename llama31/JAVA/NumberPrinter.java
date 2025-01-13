import java.lang.String;

public class NumberPrinter {
    public void run() {
        System.out.println("Thread started");
        for (int i = 1; i < 1000000000; i++) {
            if (i % 500000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Thread finished");
    }

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        printer.run();
    }
}