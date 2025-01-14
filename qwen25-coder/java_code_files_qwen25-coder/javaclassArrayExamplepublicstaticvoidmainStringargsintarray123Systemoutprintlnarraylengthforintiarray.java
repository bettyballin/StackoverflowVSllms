import java.lang.String;

public class javaclassArrayExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(array.length); // length gives a single value, like scalar context
        for (int i : array) {           // iterating over an array is like list context
            System.out.print(i);
        }
    }
}