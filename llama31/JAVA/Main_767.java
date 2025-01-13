public class Main_767 {
    public static void main(String[] args) {
        Main main = new Main();
        main.foo("some string");
    }

    public void foo(String s) {
        Predef$.MODULE$.println(foo(2));
    }

    public int foo(int i) {
        // You need to implement the logic for foo(int) method
        return i;
    }
}

class Predef$ {
    public static Predef$ MODULE$ = new Predef$();

    public void println(Object obj) {
        System.out.println(obj);
    }
}