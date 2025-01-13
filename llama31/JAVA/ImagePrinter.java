import java.util.HashMap;
import java.util.Map;

class Image {
    @Override
    public String toString() {
        return "Image"; // You can replace this with your actual image representation
    }
}

public class ImagePrinter {
    public static void main(String[] args) {
        Map<String, Image> myMap = new HashMap<>();
        myMap.put("key1", new Image());
        myMap.put("key2", new Image());

        for (Image img : myMap.values()) {
            System.out.println(img);
        }
    }
}