public class Main_14 {
    public static Object getLastElement(Object[] array) {
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 4, 5};
        System.out.println(getLastElement(array));
    }
}