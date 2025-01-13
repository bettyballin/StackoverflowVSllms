import java.lang.Integer;
import java.lang.String;

public class Tuple2<T1, T2> {
    public T1 _1;
    public T2 _2;

    public Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }
}

public class Foo {
    public static Tuple2<Integer, Integer> foo(int c) {
        return new Tuple2<>(1, 2);
    }

    public static void main(String[] args) {
        int c = 0; // define variable c
        Tuple2<Integer, Integer> result = Foo.foo(c);
        int a = result._1;
        int b = result._2;
        System.out.println(a); // print value of a
        System.out.println(b); // print value of b
    }
}