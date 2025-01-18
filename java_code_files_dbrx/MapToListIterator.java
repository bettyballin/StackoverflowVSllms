import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Image;

public class MapToListIterator {
    Map<String, Image> myMap = new HashMap<>();

    List<Map.Entry<String, Image>> list = new ArrayList<>(myMap.entrySet());
    //... add values into 'list' as per need ...

    {
        for (Map.Entry<String, Image> entry : list) {
            // Iterate the list which contains Map entries
        }
    }

    public static void main(String[] args) {
    }
}