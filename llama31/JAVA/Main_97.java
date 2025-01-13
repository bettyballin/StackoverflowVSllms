import java.lang.String;
interface Printable {
    void print();
}

public class Main_97 {
    public static void main(String[] args) {
        Printable printable = new Printable() {
            @Override
            public void print() {
                System.out.println("Hello, World!");
            }
        };
        printable.print();
    }
}