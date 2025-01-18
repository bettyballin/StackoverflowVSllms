import java.util.Map;
import java.util.TreeMap;

public class SortedImageStore {
    TreeMap<String, Image> myMap = new TreeMap<String, Image>();

    {
        //... add values here ...

        for (Map.Entry<String, Image> e : myMap.entrySet()) {
            // Here 'e' will hold the image object and corresponding key in sorted order of keys)
        }
    }

    public static void main(String[] args) {
    }
}

class Image {
    // Dummy Image class
}