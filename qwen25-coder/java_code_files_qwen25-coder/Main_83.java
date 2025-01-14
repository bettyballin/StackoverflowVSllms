import java.util.HashMap;
import java.util.Map;

public class Main {

    static final int NUMBER_OF_RUNS = 1000000;
    static final int MAX_VALUE = 10;
    static int res = 0;

    static final int[] valuesArray = new int[MAX_VALUE];
    static final Map<Integer, Integer> valuesMap = new HashMap<>();

    static {
        for (int i = 0; i < MAX_VALUE; i++) {
            valuesArray[i] = i * 2;
            valuesMap.put(i, i * 2);
        }
    }

    public static void main(String[] args) {
        long time;

        System.out.println("Array:");
        time = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            res = getValueFromArray(i % MAX_VALUE); // Using array lookup
        }
        System.out.println(System.currentTimeMillis() - time);

        System.out.println("HashMap:");
        time = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            res = getValueFromHashMap(i % MAX_VALUE); // Using HashMap lookup
        }
        System.out.println(System.currentTimeMillis() - time);

        System.out.println("Jon Skeet:");
        time = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            res = getValueFromJonSkeet(i % MAX_VALUE); // Using Jon Skeet method
        }
        System.out.println(System.currentTimeMillis() - time);

        System.out.println("Switch:");
        time = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            res = getValueFromSwitch(i % MAX_VALUE); // Using switch statement
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    static int getValueFromArray(int i) {
        return valuesArray[i];
    }

    static int getValueFromHashMap(int i) {
        return valuesMap.get(i).intValue();
    }

    enum MyEnum {
        ZERO(0),
        ONE(2),
        TWO(4),
        THREE(6),
        FOUR(8),
        FIVE(10),
        SIX(12),
        SEVEN(14),
        EIGHT(16),
        NINE(18);

        int value;

        MyEnum(int value) {
            this.value = value;
        }

        static final MyEnum[] valuesArray = values();

        static int getValue(int i) {
            return valuesArray[i].value;
        }
    }

    static int getValueFromJonSkeet(int i) {
        return MyEnum.getValue(i);
    }

    static int getValueFromSwitch(int i) {
        switch (i) {
            case 0: return 0;
            case 1: return 2;
            case 2: return 4;
            case 3: return 6;
            case 4: return 8;
            case 5: return 10;
            case 6: return 12;
            case 7: return 14;
            case 8: return 16;
            case 9: return 18;
            default: return -1;
        }
    }
}