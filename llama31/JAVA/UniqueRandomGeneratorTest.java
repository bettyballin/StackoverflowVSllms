import java.lang.String;

public class UniqueRandomGeneratorTest {
    public static void main(String[] args) {
        UniqueRandomGenerator generator = new UniqueRandomGenerator(1001);
        for (int i = 0; i < 1001; i++) {
            System.out.println(generator.next());
        }
    }
}

class UniqueRandomGenerator {
    private int[] array;
    private int index;

    public UniqueRandomGenerator(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        shuffle(array);
    }

    public int next() {
        return array[index++];
    }

    private void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}