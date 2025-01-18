import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.Image;

public class MapIterator {

    LinkedHashMap<String, Image> myMap = new LinkedHashMap<String, Image>();
    //... add values here ...

    public static void main(String[] args) {
        MapIterator mi = new MapIterator();
        for (Map.Entry<String, Image> e : mi.myMap.entrySet()) {
            // Here 'e' will hold the image object and corresponding key in order they are added to map
        }
    }
}