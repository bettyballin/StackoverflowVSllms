import java.lang.String;

public class ImageResizer {
    public static void main(String[] args) {
        ImageResizer resizer = new ImageResizer();
    }

    String originalPath = "/path/to/car.jpg";
    String largePath = originalPath.replace(".jpg", "_large.jpg");
    String mediumPath = originalPath.replace(".jpg", "_medium.jpg");
    String smallPath = originalPath.replace(".jpg", "_small.jpg");
}