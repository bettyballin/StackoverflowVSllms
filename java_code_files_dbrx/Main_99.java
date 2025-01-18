import java.lang.String;
import java.lang.ArrayList;
import java.lang.List;
import java.util.*;
public class Main_99 {
    public static void main(String[] args) {
        StringCollection collection = new StringCollection();
        collection.add("a"); // add elements to the StringCollection as needed
        List<String> list = new ArrayList<>(collection.stringList()); // convert it to List<String>
        for (String str : list) {
            System.out.println(str);  // print each element of the list, one per line
        }
    }
}

class StringCollection {
    private List<String> strings = new ArrayList<>();

    public void add(String s) {
        strings.add(s);
    }

    public List<String> stringList() {
        return strings;
    }
}