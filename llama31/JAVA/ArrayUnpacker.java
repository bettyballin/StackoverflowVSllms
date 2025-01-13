import java.util.function.Consumer;

public class ArrayUnpacker {
    public static void unpack(double[] array, Consumer<Double>... consumers) {
        for (int i = 0; i < consumers.length; i++) {
            consumers[i].accept(array[i]);
        }
    }
    public static void main(String[] args) {
    }
}