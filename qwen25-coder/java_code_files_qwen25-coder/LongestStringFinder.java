import java.util.List;

class MyObject {
    private String val1;

    public MyObject(String val1) {
        this.val1 = val1;
    }

    public String getVal1() {
        return val1;
    }
}

public class LongestStringFinder {

    public static MyObject getObjectWithLongestString(List<MyObject> objects) {
        MyObject longestStringObject = null;
        int maxLength = 0;

        for (MyObject obj : objects) {
            if (obj.getVal1() != null && obj.getVal1().length() > maxLength) {
                maxLength = obj.getVal1().length();
                longestStringObject = obj;
            }
        }

        return longestStringObject;
    }

    public static void main(String[] args) {
        List<MyObject> myObjects = List.of(
            new MyObject("a"),
            new MyObject("aa"),
            new MyObject("aba"),
            new MyObject("c")
        );

        MyObject result = getObjectWithLongestString(myObjects);
        if (result != null) {
            System.out.println("Object with longest string: " + result.getVal1());
        } else {
            System.out.println("No objects found.");
        }
    }
}