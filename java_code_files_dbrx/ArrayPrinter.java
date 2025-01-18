import java.lang.String;
public class ArrayPrinter {
    static int[] array = {1, 2, 3};

    public static void main(String[] args) {
        for(int i = 0; i < array.length; i++){
            print(array[i]);
        }
    }

    public static void print(int x) {
        System.out.println(x);
    }
}