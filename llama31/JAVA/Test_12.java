import java.util.HashMap;

public class Test_12_12 {
    public static void myMethod(HashMap map) {
        HashMap<String, String> stringMap = (HashMap<String, String>) map;
        System.out.println(stringMap);
    }

    public static void myMethod(String[][] array) {
        System.out.println(array);
    }

    public static void main(String[] args) {
        HashMap<String, String> myHashMap = new HashMap<>();
        myHashMap.put("key", "value");
        myMethod(myHashMap);

        String[][] myArray = {{"Hello", "World"}, {"Foo", "Bar"}};
        myMethod(myArray);
    }
}